package application;

import javafx.application.Application;
import javafx.stage.Stage;
import model.database.SandwichDatabase;
import view.AdminView;
import view.KitchenView;
import view.OrderView;


public class BroodjeszaakMain extends Application {
	@Override
	public void start(Stage primaryStage) {

		SandwichDatabase sandwichDatabase = SandwichDatabase.getInstance();
		AdminView adminView = new AdminView();
		OrderView orderView = new OrderView();
		KitchenView kitchenView = new KitchenView();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
