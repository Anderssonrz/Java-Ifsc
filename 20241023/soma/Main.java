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
			primaryStage.setTitle("Somando 2 numeros - Feito no IFSC Rau!");

			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Scene scene = new Scene(grid, 600, 300);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			Text scenetitle = new Text("Soma");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			Label lblNum1 = new Label("numeros 1");
			grid.add(lblNum1, 0, 1);

			TextField txtNum1 = new TextField();
			grid.add(txtNum1, 1, 1);

			Label lblNum2 = new Label("numeros 2");
			grid.add(lblNum2, 0, 2);

			TextField txtNum2 = new TextField();
			grid.add(txtNum2, 1, 2);

			Button btnSomar = new Button("Somar");
			Button btnSubtrair = new Button("Subtrair");
			Button btnDividir = new Button("Dividir");
			Button btnMultiplicar = new Button("Multiplicar");
			Button btnLimpar = new Button("Limpar");
			HBox caixaBtn = new HBox(10);

			caixaBtn.setAlignment(Pos.BOTTOM_RIGHT);
			caixaBtn.getChildren().add(btnSomar);
			caixaBtn.getChildren().add(btnSubtrair);
			caixaBtn.getChildren().add(btnDividir);
			caixaBtn.getChildren().add(btnMultiplicar);
			caixaBtn.getChildren().add(btnLimpar);

			grid.add(caixaBtn, 1, 4);

			final Text resultado = new Text();
			grid.add(resultado, 1, 6);

			btnSomar.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Double numero1 = Double.parseDouble(txtNum1.getText());
					Double numero2 = Double.parseDouble(txtNum2.getText());

					numero1 = numero1 + numero2;

					resultado.setFill(Color.FIREBRICK);
					resultado.setText("Total: " + numero1);

				}
			});

			btnMultiplicar.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Double numero1 = Double.parseDouble(txtNum1.getText());
					Double numero2 = Double.parseDouble(txtNum2.getText());

					numero1 = numero1 * numero2;

					resultado.setFill(Color.FIREBRICK);
					resultado.setText("Total: " + numero1);

				}
			});

			btnDividir.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Double numero1 = Double.parseDouble(txtNum1.getText());
					Double numero2 = Double.parseDouble(txtNum2.getText());

					numero1 = numero1 / numero2;

					resultado.setFill(Color.FIREBRICK);
					resultado.setText("Total: " + numero1);

				}
			});
			
			btnSubtrair.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Double numero1 = Double.parseDouble(txtNum1.getText());
					Double numero2 = Double.parseDouble(txtNum2.getText());

					numero1 = numero1 - numero2;

					resultado.setFill(Color.FIREBRICK);
					resultado.setText("Total: " + numero1);

				}
			});

			btnLimpar.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {

					txtNum1.setText("");
					txtNum2.clear();
					resultado.setText(new String());
					txtNum1.requestFocus();

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
