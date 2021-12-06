package application;

import controller.AdminViewController;
import controller.OrderViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import model.OrderFacade;
import view.adminPane.AdminView;
import view.KitchenView;
import view.orderMainPane.OrderView;

import java.io.IOException;


public class BroodjeszaakMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException, BiffException {

		OrderFacade orderFacade = OrderFacade.getInstance();

		AdminViewController adminViewController = new AdminViewController(orderFacade);
		AdminView adminView = new AdminView(adminViewController);

		KitchenView kitchenView = new KitchenView();

		OrderViewController orderViewController = new OrderViewController(orderFacade);
		OrderView orderView = new OrderView(orderViewController);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
