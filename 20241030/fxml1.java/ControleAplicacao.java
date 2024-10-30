package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleAplicacao {

	@FXML
	Label lblMensagem;

	@FXML
	TextField txtNome;

	public void atualizaMensagem() {
		this.lblMensagem.setText("Olá, " + txtNome.getText() + ", bem-vindo!");
	}

}
