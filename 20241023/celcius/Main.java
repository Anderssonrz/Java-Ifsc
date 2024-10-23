package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Converter graus Fahrenheit para Celcius - Feito no IFSC Rau!");

			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Scene scene = new Scene(grid, 600, 300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			Text scenetitle = new Text("Fahrenheit para Celcius");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			Label lblNum1 = new Label("Fahrenheit");
			grid.add(lblNum1, 0, 1);

			TextField txtNum1 = new TextField();
			grid.add(txtNum1, 1, 1);


			Button btnConverter = new Button("Converter");
			
			sa
s
			HBox caixaBtn = new HBox(10);

			
			caixaBtn.getChildren().add(btnConverter);

			grid.add(caixaBtn, 1, 4);

			final Text resultado = new Text();
			grid.add(resultado, 1, 6);

			btnConverter.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Double numero1 = Double.parseDouble(txtNum1.getText());

					numero1 = (numero1-32) / 1.8000	;

					resultado.setFill(Color.FIREBRICK);
					resultado.setText("%.2f °C: " + numero1);

				}
			});




			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
