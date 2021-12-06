package view.orderMainPane;

import controller.OrderViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import view.adminPane.AdminMainPane;

public class OrderView {
	private Stage stage = new Stage();		
		
	public OrderView(OrderViewController orderViewController){
		stage.setTitle("ORDER VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(20);
		stage.setY(20);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 650);
		GridPane gridPane = new OrderMainPane(orderViewController.getOrderFacade());
		gridPane.prefHeightProperty().bind(scene.heightProperty());
		gridPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(gridPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}
