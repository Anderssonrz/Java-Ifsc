package com.peregrinoti.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.peregrinoti.entity.Amigo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AmigoEditController implements Initializable {

    @FXML
    private AnchorPane pnlPrincipal;

    @FXML
    private GridPane pnlDados;

    @FXML
    private Label lblNome;

    @FXML
    private TextField txtNome;

    @FXML
    private Label lblResponsavel;

    @FXML
    private TextField txtResponsavel;

    @FXML
    private Label lblTelefone;

    @FXML
    private TextField txtTelefone;

    @FXML
    private Label lblEndereco;

    @FXML
    private TextField txtEndereco;

    @FXML
    private HBox pnlBotoes;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancela;
    
	private Stage janelaAmigoEdit;

	private Amigo amigo;

	private boolean okClick = false;

    @FXML
    void onClickBtnCancela(ActionEvent event) {
    	this.getJanelaAmigoEdit().close();
    }

    @FXML
    void onClickBtnOK(ActionEvent event) {
    	if (validarCampos()) {
			this.amigo.setNome(this.txtNome.getText());
			this.amigo.setNomeResponsavel(this.txtResponsavel.getText());
			this.amigo.setTelefone(this.txtTelefone.getText());
			this.amigo.setEndereco(this.txtEndereco.getText());

			this.okClick = true;
			this.getJanelaAmigoEdit().close();
		}
    }
    
    public Stage getJanelaAmigoEdit() {
		return janelaAmigoEdit;
	}

	public void setJanelaAmigoEdit(Stage janelaAmigoEdit) {
		this.janelaAmigoEdit = janelaAmigoEdit;
	}
	
	public void populaTela(Amigo amigo) {
		this.amigo = amigo;

		this.txtNome.setText(amigo.getNome());
		this.txtResponsavel.setText(amigo.getNomeResponsavel());
		this.txtTelefone.setText(amigo.getTelefone());
		this.txtEndereco.setText(amigo.getEndereco());
	}
	
	public boolean isOkClick() {
		return okClick;
	}
	
	private boolean validarCampos() {
		String mensagemErros = new String();

		if (this.txtNome.getText() == null || this.txtNome.getText().trim().length() == 0) {
			mensagemErros += "Informe o nome!\n";
		}

		if (this.txtResponsavel.getText() == null || this.txtResponsavel.getText().trim().length() == 0) {
			mensagemErros += "Informe o responsável!\n";
		}
		
		if (this.txtTelefone.getText() == null || this.txtTelefone.getText().trim().length() == 0) {
			mensagemErros += "Informe o telefone!\n";
		}
		
		if (this.txtEndereco.getText() == null || this.txtEndereco.getText().trim().length() == 0) {
			mensagemErros += "Informe o endereço!\n";
		}

		if (mensagemErros.length() == 0) {
			return true;
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.initOwner(this.janelaAmigoEdit);
			alerta.setTitle("Dados inválidos!");
			alerta.setHeaderText("Favor corrigir as seguintes informações:");
			alerta.setContentText(mensagemErros);
			alerta.showAndWait();

			return false;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}

