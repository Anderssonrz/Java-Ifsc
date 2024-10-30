package application;
	
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL arquivoFXML = getClass().getResource("./TelaPrincipal.fxml");
			Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
			
			primaryStage.setScene(new Scene(fxmlParent, 300, 100));
			primaryStage.setTitle("Olá mundo com FXML");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
