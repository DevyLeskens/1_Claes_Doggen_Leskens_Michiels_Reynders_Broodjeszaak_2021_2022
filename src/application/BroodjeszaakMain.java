package application;

import controller.AdminViewController;
import controller.KitchenViewController;
import controller.OrderViewController;
import excel.ExcelPlugin;
import javafx.application.Application;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.OrderFacade;
import model.database.SandwichDatabase;
import view.AdminView;
import view.KitchenView;
import view.OrderView;

import java.io.File;
import java.io.IOException;


public class BroodjeszaakMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException, BiffException {

		OrderFacade orderFacade = OrderFacade.getInstance();

		AdminViewController adminViewController = new AdminViewController(orderFacade);
		AdminView adminView = new AdminView(adminViewController);

		KitchenView kitchenView = new KitchenView();
		OrderView orderView = new OrderView();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
