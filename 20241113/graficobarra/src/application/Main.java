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
	public static String ARGENTINA = "Argentina";


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
			series1.getData().add(new XYChart.Data(Main.ARGENTINA, 20148.82));


			XYChart.Series series2 = new XYChart.Series();
			series2.setName("2004");
			series2.getData().add(new XYChart.Data(Main.AUSTRIA, 57401.85));
			series2.getData().add(new XYChart.Data(Main.BRASIL, 41941.19));
			series2.getData().add(new XYChart.Data(Main.ARGENTINA, 75111.82));

			
			XYChart.Series series3 = new XYChart.Series();
			series3.setName("2005");
			series3.getData().add(new XYChart.Data(Main.AUSTRIA, 41131.85));
			series3.getData().add(new XYChart.Data(Main.BRASIL, 77747.19));
			series3.getData().add(new XYChart.Data(Main.ARGENTINA, 60555.82));
			
			XYChart.Series series4 = new XYChart.Series();
			series4.setName("2006");
			series4.getData().add(new XYChart.Data(Main.AUSTRIA, 78888.85));
			series4.getData().add(new XYChart.Data(Main.BRASIL, 9250.19));
			series4.getData().add(new XYChart.Data(Main.ARGENTINA, 70555.82));

			
			Scene scene = new Scene(grafico, 800, 600 );
			grafico.getData().addAll(series1, series2, series3, series4);
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
