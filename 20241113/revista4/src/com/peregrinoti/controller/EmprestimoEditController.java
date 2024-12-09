package com.peregrinoti.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.peregrinoti.entity.Amigo;
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

	private Revista emprestimo;

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
			this.emprestimo.setNomeAmigo(this.txtNomeAmigo.getText());
			this.emprestimo.setTelefoneAmigo(this.txtTelefoneAmigo.getText());
			this.emprestimo.setNomeRevista(this.txtNomeRevista.getText());
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

public void setJanelaRevistaEdit(Stage janelaEmprestimoEdit) {
	this.janelaEmprestimoEdit = janelaEmprestimoEdit;
}

public void populaTela(Revista emprestimo) {
	this.emprestimo = emprestimo;

	this.txtNomeAmigo.setText(this.emprestimo.getNome());

	if (this.emprestimo.getAmigo() != null) {
		this.txtTelefoneAmigo.setText(this.emprestimo.getAmigo());
	}

	if (this.emprestimo.getRevista() != null) {
		this.txtNomeRevista.setText(this.emprestimo.getRevista());
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
		mensagemErros += "Informe o nome!\n";
	}

	if (mensagemErros.length() == 0) {
		return true;
	} else {
		Alert alerta = new Alert(Alert.AlertType.ERROR);
		alerta.initOwner(this.janelaRevistaEdit);
		alerta.setTitle("Dados inválidos!");
		alerta.setHeaderText("Favor corrigir as seguintes informações:");
		alerta.setContentText(mensagemErros);
		alerta.showAndWait();

		return false;
	}
}

public void carregarTextFieldAmigo() {
	ObservableList<Amigo> observableListaAmigo = FXCollections
			.observableArrayList(this.amigoListaController.retornaListagemAmigo());

	this.txtNomeAmigo.setNomeAmigo(observableListaAmigo);
	this.txtTelefoneAmigo.setTelefoneAmigo(observableListaAmigo);

}

public void carregarTextFieldRevista() {
	ObservableList<Revista> observableListaRevista = FXCollections
			.observableArrayList(this.revistaListaController.retornaListagemRevista());

	this.txtNomeRevista.setNomeRevista(observableListaRevista);
}
}

