package com.peregrinoti.controller;

import java.util.Optional;

import com.peregrinoti.entity.Amigo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

public class AmigoListaController {

    @FXML
    private AnchorPane pnlPrincipal;

    @FXML
    private SplitPane pnlDivisao;

    @FXML
    private AnchorPane pnlEsquerda;

    @FXML
    private TableView<Amigo> tbvAmigos;

    @FXML
    private TableColumn<Amigo, Long> tbcCodigo;

    @FXML
    private TableColumn<Amigo, String> tbcNome;

    @FXML
    private AnchorPane pnlDireita;

    @FXML
    private Label lblDetalhes;

    @FXML
    private GridPane pnlDetalhes;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblTelefone;

    @FXML
    private Label lblNomeValor;

    @FXML
    private Label lblTelefoneValor;

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
		Amigo amigo = this.tbvAmigos.getSelectionModel().getSelectedItem();

		if (amigo != null) {

			Alert alerta = new Alert(AlertType.CONFIRMATION);
			alerta.setTitle("Pergunta");
			alerta.setHeaderText("Confirma a exclusão da amigo?\n" + amigo.getNome());

			ButtonType botaoNao = ButtonType.NO;
			ButtonType botaoSim = ButtonType.YES;
			alerta.getButtonTypes().setAll(botaoSim, botaoNao);
			Optional<ButtonType> resultado = alerta.showAndWait();

			if (resultado.get() == botaoSim) {
				this.getAmigoDAO().delete(amigo);
				this.carregarTableViewAmigo();
			}
		} else {
			Alert alerta = new Alert(Alert.AlertType.ERROR);
			alerta.setContentText("Por favor, escolha um amigo     na tabela!");
			alerta.show();
		}
    }

    @FXML
    void onClickBtnIncluir(ActionEvent event) {

    }

}
