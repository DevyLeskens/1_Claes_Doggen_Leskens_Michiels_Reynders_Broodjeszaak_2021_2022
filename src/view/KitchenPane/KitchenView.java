package view.KitchenPane;

import controller.KitchenViewController;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.OrderLine;

import java.util.HashMap;


public class KitchenView {
	KitchenViewController kitchenViewController;
	private Stage stage = new Stage();
	public  VBox vBox = new VBox();
	private Label countOrders = new Label();
	private BorderPane borderPane = new BorderPane();

	public KitchenView(KitchenViewController kitchenViewController){
		kitchenViewController.setKitchenView(this);

		//countorders label
		countOrders.setText("Count of orders in waiting line: None" );
		countOrders.setFont(Font.font("Verdana", 20));
		countOrders.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN,new CornerRadii(0),new Insets(0))));
		countOrders.setPadding(new Insets(5,5,5,10));

		//stage
		stage.setTitle("KITCHEN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(880);
		stage.setY(470);

		//group
		Group root = new Group();
		Scene scene = new Scene(root, 650, 205);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
		this.kitchenViewController = kitchenViewController;

		//VBox Style
		vBox.setBackground(new Background(new BackgroundFill(Color.SNOW,new CornerRadii(0),new Insets(0))));
		vBox.getChildren().addAll(borderPane , new OrderDetails(kitchenViewController), new Buttons(kitchenViewController));
		vBox.prefHeightProperty().bind(scene.heightProperty());
		vBox.prefWidthProperty().bind(scene.widthProperty());

		//add vbox to root
		borderPane.setCenter(countOrders);
		borderPane.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN,new CornerRadii(0),new Insets(0))));
		root.getChildren().add(vBox);

	}
	public void update(int countorder, boolean orderisinspected, HashMap<OrderLine, Integer> order){
		countOrders.setText("Count of orders in waiting line: " + countorder);
		Buttons.update(countorder, orderisinspected, order);

	}

}
