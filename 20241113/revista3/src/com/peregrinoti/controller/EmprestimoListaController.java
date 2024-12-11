package com.peregrinoti.controller;

import java.sql.Date;
import java.util.Optional;

import com.peregrinoti.entity.Emprestimo;

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

	}

	@FXML
	void onClickBtnExcluir(ActionEvent event) {

	}

	@FXML
	void onClickBtnIncluir(ActionEvent event) {

	}
	
	public boolean onCloseQuery() {
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
		alerta.setTitle("Pergunta");
		alerta.setHeaderText("Deseja sair do cadastro de caixa?");
		ButtonType buttonTypeNO = ButtonType.NO;
		ButtonType buttonTypeYES = ButtonType.YES;
		alerta.getButtonTypes().setAll(buttonTypeYES, buttonTypeNO);
		Optional<ButtonType> result = alerta.showAndWait();
		return result.get() == buttonTypeYES ? true : false;
	}
	
	
}