package application;

import controller.AdminViewController;
import controller.KitchenViewController;
import controller.OrderViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.database.SandwichDatabase;
import view.AdminView;
import view.KitchenView;
import view.OrderView;


public class BroodjeszaakMain extends Application {
	@Override
	public void start(Stage primaryStage) {

		AdminViewController adminViewController = new AdminViewController();
		KitchenViewController kitchenViewController = new KitchenViewController();
		OrderViewController orderViewController = new OrderViewController();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
