package com.peregrinoti.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.peregrinoti.entity.Amigo;
import com.peregrinoti.entity.Emprestimo;
import com.peregrinoti.entity.Revista;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EmprestimoEditController implements Initializable {

	@FXML
	private AnchorPane pnlPrincipal;

	@FXML
	private GridPane pnlDados;

	@FXML
	private Label lblNomeAmigo;

	@FXML
	private TextField txtNomeAmigo;

	@FXML
	private Label lblTelefoneAmigo;

	@FXML
	private Label lblNomeRevista;

	@FXML
	private Label lblAno;

	@FXML
	private TextField txtTelefoneAmigo;

	@FXML
	private DatePicker dtpAno;

	@FXML
	private TextField txtNomeRevista;

	@FXML
	private HBox pnlBotoes;

	@FXML
	private Button btnOK;

	@FXML
	private Button btnCancela;

	private Stage janelaEmprestimoEdit;

	private Emprestimo emprestimo;

	private boolean okClick = false;

	private AmigoListaController amigoListaController;
	private RevistaListaController revistaListaController;

	@FXML
	void onClickBtnCancela(ActionEvent event) {
		this.getjanelaEmprestimoEdit().close();
	}

	@FXML
	void onClickBtnOK(ActionEvent event) {
		if (validarCampos()) {
			this.emprestimo.setAmigo(this.txtNomeAmigo.getText());
			this.emprestimo.setAmigo(this.txtTelefoneAmigo.getText());
			this.emprestimo.setRevista(this.txtNomeRevista.getText());
			this.emprestimo.setAno(Date.valueOf(this.dtpAno.getValue()));

			this.okClick = true;
			this.getjanelaEmprestimoEdit().close();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.amigoListaController = new AmigoListaController();
		this.revistaListaController = new RevistaListaController();

		this.carregarTextFieldAmigo();
		this.carregarTextFieldRevista();
	}

	public Stage getjanelaEmprestimoEdit() {
		return janelaEmprestimoEdit;
	}

	public void setJanelaEmprestimoEdit(Stage janelaEmprestimoEdit) {
		this.janelaEmprestimoEdit = janelaEmprestimoEdit;
	}

	public void populaTela(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;

		this.txtNomeAmigo.setText(this.emprestimo.getNome());

		if (this.emprestimo.getAmigo() != null) {
			this.txtTelefoneAmigo.setValue(this.emprestimo.getAmigo());
		}

		if (this.emprestimo.getRevista() != null) {
			this.txtNomeRevista.setValue(this.emprestimo.getRevista());
		}
		if (this.emprestimo.getAno() != null) {
			this.dtpAno.setValue(this.emprestimo.getAno().toLocalDate());
		}
	}

	public boolean isOkClick() {
		return okClick;
	}

	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.txtNomeAmigo.getText() == null || this.txtNomeAmigo.getText().trim().length() == 0) {
			mensagemErros += "Informe o nome do amigo!\n";
		}
		if (this.txtTelefoneAmigo.getText() == null || this.txtTelefoneAmigo.getText().trim().length() == 0) {
			mensagemErros += "Informe o telefone do amigo!\n";
		}

		if (this.txtNomeAmigo.getText() == null || this.txtNomeRevista.getText().trim().length() == 0) {
			mensagemErros += "Informe o nome da revista!\n";
		}

		if (mensagemErros.length() == 0) {
			return true;
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaEmprestimoEdit);
			alerta.setTitle("Dados inválidos!");
			alerta.setHeaderText("Favor corrigir as seguintes informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();

			return false;
		}
	}
}
