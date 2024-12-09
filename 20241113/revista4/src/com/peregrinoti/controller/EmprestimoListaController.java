package com.peregrinoti.controller;

import java.sql.Date;
import java.util.Optional;

import com.peregrinoti.entity.Emprestimo;
import com.peregrinoti.entity.Revista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class EmprestimoListaController {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private SplitPane pnlDivisao;

	@FXML
	private AnchorPane pnlEsquerda;

	@FXML
	private TableView<?> tbvEmprestimos;

	@FXML
	private TableColumn<Emprestimo, Long> tbcCodigo;

	//TODO verificar a conversão do tipo de data 
	@FXML
	private TableColumn<Emprestimo, Date> tbcDataDevolucao;

	@FXML
	private AnchorPane pnlDireita;

	@FXML
	private Label lblDetalhes;

	@FXML
	private GridPane pnlDetalhes;

	@FXML
	private Label lblNomeAmigo;

	@FXML
	private Label lblNomeAmigoValor;

	@FXML
	private Label lblTelefoneAmigo;

	@FXML
	private Label lblTelefoneAmigoValor;

	@FXML
	private Label lblNomeRevista;

	@FXML
	private Label lblNomeRevistaValor;

	@FXML
	private Label lblAno;

	@FXML
	private Label lblAnoValor;

	@FXML
	private ButtonBar barBotoes;

	@FXML
	private Button btnInclur;

	@FXML
	private Tooltip tlpIncluir;
a
	@FXML
	private Button btnEditar;

	@FXML
	private Tooltip tlpEditar;

	@FXML
	private Button btnExcluir;

	@FXML
	private Tooltip tlpExcluir;

	@FXML
	void onClickBtnEditar(ActionEvent event) {
		Emprestimo emprestimo = this.tbvEmpretimos.getSelectionModel().getSelectedItem();

		if (emprestimo != null) {
			boolean btnConfirmarClic = this.onShowTelaEmpretimoEditar(emprestimo, RevistaListaController.EMPRESTIMO_EDITAR);

			if (btnConfirmarClic) {
				this.getEmpretimoDAO().update(emprestimo, null);
				this.carregarTableViewEmpretimos();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha um EMPRESTIMO na tabela!");
			alerta.show();
		}
	}

	@FXML
	void onClickBtnExcluir(ActionEvent event) {
		Revista emprestimo = this.tbvEmpretimos.getSelectionModel().getSelectedItem();

		if (emprestimo != null) {

			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Pergunta");
			alerta.setHeaderText("Confirma a exclusão da revista?\n" + emprestimo.getNome());

			ButtonType botaoNao = ButtonType.NO;
			ButtonType botaoSim = ButtonType.YES;
			alerta.getButtonTypes().setAll(botaoSim, botaoNao);
			Optional<ButtonType> resultado = alerta.showAndWait();

			if (resultado.get() == botaoSim) {
				this.getEmpretimoDAO().delete(emprestimo);
				this.carregarTableViewEmpretimos();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha uma revista na tabela!");
			alerta.show();
		}
	}

	@FXML
	void onClickBtnIncluir(ActionEvent event) {

	}
	public boolean onCloseQuery() {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Pergunta");
		alerta.setHeaderText("Deseja sair do emprestimo?");
		ButtonType buttonTypeNO = ButtonType.NO;
		ButtonType buttonTypeYES = ButtonType.YES;
		alerta.getButtonTypes().setAll(buttonTypeYES, buttonTypeNO);
		Optional<ButtonType> result = alerta.showAndWait();
		return result.get() == buttonTypeYES ? true : false;
	}
}