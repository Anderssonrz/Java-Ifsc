package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


public class Main extends Application {
	public static final int GRAFIC_LARGURA = 300;
	public static final int GRAFIC_ALTURA = 300;

	@Override
	public void start(Stage primaryStage) {
		try {
			Scene scene = new Scene(new Group());
			primaryStage.setTitle("Vendas");
			primaryStage.setWidth(500);
			primaryStage.setWidth(500);

			ObservableList<PieChart.Data> dadosGraficos = FXCollections.observableArrayList(
					new PieChart.Data("Trimestre 1", 13), new PieChart.Data("Trimestre 2", 25),
					new PieChart.Data("Trimestre 3", 10), new PieChart.Data("Trimestre 4", 22));
			final PieChart grafico = new PieChart(dadosGraficos);
			grafico.setTitle("Lucros por trimestre");
			
			((Group) scene.getRoot()).getChildren().add(grafico);
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
