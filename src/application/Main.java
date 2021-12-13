package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import model.database.SandwichDatabase;
import model.domain.Sandwich;

import java.awt.*;
import java.util.Collection;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = createNodeHierarchy();
			primaryStage.setScene(new Scene(root));
			primaryStage.setTitle("Broodjeszaak");
			primaryStage.show();
			root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private Pane createNodeHierarchy() {
		Pane border = new Pane();


		Button upperleft = new Button("upperleft");
		Button comboBox = new Button("combobox");
		Button buttonInTilePane = new Button("buttonInTilePane");
		Button bla = new Button("bla");

		VBox mainBorder = new VBox();
		mainBorder.setMinSize(1200, 700);
		mainBorder.setSpacing(10);
		mainBorder.setMaxWidth(1000);
		mainBorder.setBackground(new Background(new BackgroundFill(Color.LIGHTCYAN, new CornerRadii(0), new Insets(0))));

		BorderPane p11 = new BorderPane();
		p11.setMinSize(1100, 30);


		VBox p1 = new VBox();
//		for (Sandwich sandwich:
//			 ) {
//
//		}
		BorderPane borderPane1 = new BorderPane();
		borderPane1.setBackground(new Background(new BackgroundFill(Color.BLUE, new CornerRadii(0), new Insets(0))));
		borderPane1.setRight(buttonInTilePane);
		TilePane tilePane = new TilePane();


		BorderPane top = new BorderPane();
		top.setMinSize(1100, 30);
		Button left = new Button();
		left.setMinSize(200, 40);
		left.setText("new order");
		ComboBox comboBox1 = new ComboBox();
		comboBox1.setValue("combobox");
		comboBox1.setMinSize(300, 40);
		Text volgnummer = new Text();
		volgnummer.setText("volgnummer...");


		HBox middle = new HBox();
		middle.setMinSize(1100, 300);
		TableColumn tableColumn = new TableColumn();



		VBox p2 = new VBox();
		p2.setMinSize(400, 280);






		//add all the children
		//to p1
		p1.getChildren().addAll(borderPane1, tilePane);
		//to p2
		p2.getChildren().addAll();

		//to middle
		middle.getChildren().addAll(p2);

		//to top
		top.setLeft(left);
		top.setRight(comboBox1);
		top.setCenter(volgnummer);

		//to mainBorder
		mainBorder.getChildren().addAll(top, p1, middle );

		//to pane
		border.getChildren().addAll(mainBorder);


		return border;

	}
	public static void main(String[] args) {
		launch(args);
	}
}
