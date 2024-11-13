package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class Main extends Application {
	public static String AUSTRIA = "Áustria";
	public static String BRASIL = "Brasil";

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Exemplo grafico de barras");
			final CategoryAxis xAxis = new CategoryAxis();
			final NumberAxis yAxis = new NumberAxis();
			final BarChart<String, Number> grafico = new BarChart<String, Number>(xAxis, yAxis);
			
			grafico.setTitle("Resumo por País");
			xAxis.setLabel("País");
			yAxis.setLabel("Valor em Vendas");
			
			XYChart.Series series1 = new XYChart.Series();
			series1.setName("2003");
			series1.getData().add(new XYChart.Data(Main.AUSTRIA, 25601.34));
			series1.getData().add(new XYChart.Data(Main.BRASIL, 20148.82));

			XYChart.Series series2 = new XYChart.Series();
			series2.setName("2004");
			series2.getData().add(new XYChart.Data(Main.AUSTRIA, 57401.85));
			series2.getData().add(new XYChart.Data(Main.BRASIL, 41941.19));
			
			Scene scene = new Scene(grafico, 800, 600);
			grafico.getData().addAll(series1, series2);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
