package com.ifsc.tds;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ContasController implements Initializable {

	@FXML
	private TableView<Conta> tblContas;
	@FXML
	private TableColumn<Conta, String> clFav;
	@FXML
	private TableColumn<Conta, String> clDesc;
	@FXML
	private TableColumn<Conta, Double> clValor;
	@FXML
	private TableColumn<Conta, Date> clVenc;
	@FXML
	private TextField txtFav;
	@FXML
	private TextField txtDesc;
	@FXML
	private TextField txtValor;
	@FXML
	private DatePicker dpVencimento;
	@FXML
	private Button btnSalvar;
	@FXML
	private Button btnAtualizar;
	@FXML
	private Button btnApagar;
	@FXML
	private Button btnLimpart;

	private ContasService service;

	// Esse m�todo � chamado ao inicializar a aplica��o, igual um construtor.
	// Ele vem da interface Initializable
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = ContasService.getNewInstance();
		configuraColunas();
		configuraBindings();
		atualizaDadosTabela();
	}

	// m�todos p�blicos chamados quando o bot�o � clicado

	public void salvar() {
		Conta c = new Conta();
		pegaValores(c);
		service.salvar(c);
		atualizaDadosTabela();
	}

	public void atualizar() {
		Conta c = tblContas.getSelectionModel().getSelectedItem();
		pegaValores(c);
		service.atualizar(c);
		atualizaDadosTabela();
	}

	public void apagar() {
		Conta c = tblContas.getSelectionModel().getSelectedItem();
		service.apagar(c.getId());
		atualizaDadosTabela();
	}

	public void limpar() {
		tblContas.getSelectionModel().select(null);
		txtFav.setText("");
		txtDesc.setText("");
		txtValor.setText("");
		dpVencimento.setValue(null);
	}

	// m�todos privados do controller

	// pega os valores entrados pelo usu�rio e adiciona no objeto conta
	private void pegaValores(Conta c) {
		Double valor = Double.parseDouble(txtValor.getText());
		c.setFavorecido(txtFav.getText());
		c.setDescricao(txtDesc.getText());
		c.setValor(valor);
		c.setDataVencimento(dataSelecionada());
	}

	// m�todo utilit�rio para pega a data que foi selecionada (que usa o tipo novo
	// do java 8 LocalDateTime)
	private Date dataSelecionada() {
		LocalDateTime time = dpVencimento.getValue().atStartOfDay();
		return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
	}

	// chamado quando acontece alguma opera��o de atualiza��o dos dados
	private void atualizaDadosTabela() {
		tblContas.getItems().setAll(service.buscarTodas());
		limpar();
	}

	// configura as colunas para mostrar as propriedades da classe Conta
	private void configuraColunas() {
		clFav.setCellValueFactory(new PropertyValueFactory<>("favorecido"));
		clDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		clValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
		clVenc.setCellValueFactory(new PropertyValueFactory<>("dataVencimento"));
	}

	// configura a l�gica da tela
	private void configuraBindings() {
		// esse binding s� e false quando os campos da tela est�o preenchidos
		BooleanBinding camposPreenchidos = txtFav.textProperty().isEmpty().or(txtDesc.textProperty().isEmpty())
				.or(dpVencimento.valueProperty().isNull());
		// indica se h� algo selecionado na tabela
		BooleanBinding algoSelecionado = tblContas.getSelectionModel().selectedItemProperty().isNull();
		// alguns bot�es s� s�o habilitados se algo foi selecionado na tabela
		btnApagar.disableProperty().bind(algoSelecionado);
		btnAtualizar.disableProperty().bind(algoSelecionado);
		btnLimpart.disableProperty().bind(algoSelecionado);
		// o bot�o salvar s� � habilitado se as informa��es foram preenchidas e n�o tem
		// nada na tela
		btnSalvar.disableProperty().bind(algoSelecionado.not().or(camposPreenchidos));
		// quando algo � selecionado na tabela, preenchemos os campos de entrada com os
		// valores para o
		// usu�rio editar
		tblContas.getSelectionModel().selectedItemProperty().addListener((b, o, n) -> {
			if (n != null) {
				LocalDate data = null;
				data = n.getDataVencimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				txtFav.setText(n.getFavorecido());
				txtDesc.setText(n.getDescricao());
				txtValor.setText(String.valueOf(n.getValor()));
				dpVencimento.setValue(data);
			}
		});
	}
}
