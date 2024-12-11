package com.peregrinoti.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.peregrinoti.entity.Amigo;
import com.peregrinoti.entity.Emprestimo;
import com.peregrinoti.entity.Revista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EmprestimoEditController {

    private static final boolean okClick = false;

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
    private TextField txtTelefoneAmigo;

    @FXML
    private Label lblAno;

    @FXML
    private DatePicker dtpAno;

    @FXML
    private Label lblNomeRevista;

    @FXML
    private TextField txtNomeRevista;

    @FXML
    private HBox pnlBotoes;

    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancela;
   
    
	private Emprestimo emprestimo;
	
	private Stage janelaEmprestimoEdit;

    @FXML
    void onClickBtnCancela(ActionEvent event) {
    	this.getJanelaEmprestimoEdit().close();
    }

    @FXML
    void onClickBtnOK(ActionEvent event) {
        if (validarCampos()) {
            Amigo amigo = new Amigo();
            amigo.setNome(this.txtNomeAmigo.getText());
            amigo.setTelefone(this.txtTelefoneAmigo.getText());
            this.emprestimo.setAmigo(amigo);

            Revista revista = new Revista();
            revista.setNome(this.txtNomeRevista.getText());
            this.emprestimo.setRevista(revista);

            if (this.dtpAno.getValue() != null) {
                this.emprestimo.setDataEmprestimo(Date.valueOf(this.dtpAno.getValue()));
            } else {
                this.emprestimo.setDataEmprestimo(null);
            }

            this.getJanelaEmprestimoEdit().close();
        }
    }

    
    public void initialize(URL location, ResourceBundle resources) {
    	new AmigoListaController();
		new RevistaListaController();
		
	}

	public Stage getJanelaEmprestimoEdit() {
		return janelaEmprestimoEdit;
	}
	
	public void setJanelaEmprestimoEdit(Stage janelaEmprestimoEdit) {
		this.janelaEmprestimoEdit = janelaEmprestimoEdit;
	}
	
	
	public void populaTela(Emprestimo emprestimo) {
	    this.emprestimo = emprestimo;

	    // Preencher campos com os dados do empréstimo
	    
	    this.txtNomeAmigo.setText(emprestimo.getNomeAmigo());
	    this.txtTelefoneAmigo.setText(emprestimo.getTelefoneAmigo());

	    if (emprestimo.getDataEmprestimo() != null) {
	        this.dtpAno.setValue(emprestimo.getDataEmprestimo().toLocalDate());
	    } else {
	        this.dtpAno.setValue(null);
	    }

	    this.txtNomeRevista.setText(emprestimo.getNomeRevista());
	}


public boolean isOkClick() {
	return okClick;
}


private boolean validarCampos() {
    StringBuilder mensagemErros = new StringBuilder();

    if (this.txtNomeAmigo.getText() == null || this.txtNomeAmigo.getText().trim().isEmpty()) {
        mensagemErros.append("Informe o nome do amigo!\n");
    }

    if (this.txtTelefoneAmigo.getText() == null || this.txtTelefoneAmigo.getText().trim().isEmpty()) {
        mensagemErros.append("Informe o telefone do amigo!\n");
    }

    if (this.txtNomeRevista.getText() == null || this.txtNomeRevista.getText().trim().isEmpty()) {
        mensagemErros.append("Informe o nome da revista!\n");
    }

    if (mensagemErros.length() == 0) {
        return true;
    } else {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.initOwner(this.janelaEmprestimoEdit);
        alerta.setTitle("Dados inválidos!");
        alerta.setHeaderText("Favor corrigir as seguintes informações:");
        alerta.setContentText(mensagemErros.toString());
        alerta.showAndWait();

        return false;
    }
}



}
