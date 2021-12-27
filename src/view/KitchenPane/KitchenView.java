package view.KitchenPane;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Order;
import model.OrderFacade;
import model.OrderLine;


public class KitchenView {
	private Stage stage = new Stage();
	public static VBox vBox = new VBox();
	private Label countOrders  =new Label("Count of orders in waiting line:" + broodjescount);
	private static int broodjescount = 0;
	
	public KitchenView(){			
		stage.setTitle("KITCHEN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(880);
		stage.setY(470);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 205);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();
		//VBox Style
		vBox.setBackground(new Background(new BackgroundFill(Color.SNOW,new CornerRadii(0),new Insets(0))));
		vBox.getChildren().addAll(countOrders, new OrderDetails(), new Buttons());
		vBox.prefHeightProperty().bind(scene.heightProperty());
		vBox.prefWidthProperty().bind(scene.widthProperty());
		//add fbox to root
		root.getChildren().add(vBox);
		//styling countOrders
		countOrders.setFont(Font.font("Verdana", 20));
		countOrders.setPadding(new Insets(5,5,5,10));
	}
}
