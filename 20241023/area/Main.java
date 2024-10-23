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
import javafx.scene.control.Tooltip;
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
			primaryStage.setTitle("Cálculo área quadrado - Feito no IFSC Rau!");

			GridPane grid = new GridPane();
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			grid.setPadding(new Insets(25, 25, 25, 25));

			Scene scene = new Scene(grid, 400, 200);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			Text scenetitle = new Text("Área Quadrado");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			grid.add(scenetitle, 0, 0, 2, 1);

			Label lblLado = new Label("Lado");
			grid.add(lblLado, 0, 1);

			TextField txtLado = new TextField();
			grid.add(txtLado, 1, 1);

			Button btnArea = new Button("Área");
			Button btnLimpar = new Button("Limpar");

			btnArea.setTooltip(new Tooltip("Calcular Área"));
			btnLimpar.setTooltip(new Tooltip("Limpar"));

			HBox caixaBtn = new HBox(10);

			caixaBtn.setAlignment(Pos.BOTTOM_RIGHT);
			caixaBtn.getChildren().add(btnArea);
			caixaBtn.getChildren().add(btnLimpar);
			grid.add(caixaBtn, 1, 4);

			final Text resultado = new Text();
			grid.add(resultado, 1, 6);

			btnArea.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Double lado = Double.parseDouble(txtLado.getText());

					lado = Math.pow(lado, 2);

					resultado.setFill(Color.FIREBRICK);
					resultado.setText("Total: " + lado);

				}
			});

			btnLimpar.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					txtLado.setText("");
					resultado.setText(new String());
					txtLado.requestFocus();
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
