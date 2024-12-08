
package com.peregrinoti.controller;

import java.sql.Date;

import com.peregrinoti.entity.Emprestimo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
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
    
    //TODO (VERIFICAR  A CONVEN��O DO TIPO DE DATA)

    @FXML
    private TableColumn<Emprestimo, Date> tbcDataDevolucao;

    @FXML
    private AnchorPane pnlDireita;

    @FXML
    private Label lblDetalhes;

    @FXML
    private GridPane pnlDetalhes;

    @FXML
    private Label lblNomeamigo;

    @FXML
    private Label lblTelefoneAmigo;

    @FXML
    private Label lblNomeAmigoValor;

    @FXML
    private Label lblTelefoneAmigoValor;

    @FXML
    private Label lblNomeRevista;

    @FXML
    private Label lblNomeRevistaValor;

    @FXML
    private Label lblAno;

    @FXML
    private Label lblAnosValor;

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

}
