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
			URL fxml = getClass().getResource("./ContasTela.fxml");
			Parent parent = FXMLLoader.load(fxml);
			primaryStage.setTitle("Contas a pagar!");
			primaryStage.setScene(new Scene(parent));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

