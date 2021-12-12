package application;
	
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import  javafx.scene.control.Button;

import java.awt.*;
import java.util.Collection;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = createNodeHierarchy();
			primaryStage.setScene(new Scene(root));
			primaryStage.setTitle("Broodjeszaak");
			primaryStage.show();
			root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private GridPane createNodeHierarchy() {
		GridPane border = new GridPane();
		border.setHgap(20);
		border.setVgap(15);

		Button upperleft = new Button("upperleft");
		Button comboBox = new Button("combobox");
		Button buttonInTilePane = new Button("buttonInTilePane");
		Button bla = new Button("bla");


		VBox vbox1 = new VBox();
		TilePane tilePane1 = new TilePane();
		tilePane1.setBackground(new Background(new BackgroundFill(Color.BLUE,new CornerRadii(0), new Insets(0))));
		tilePane1.getChildren().addAll(buttonInTilePane);

		TilePane tilePane2 = new TilePane();

		tilePane2.setBackground(new Background(new BackgroundFill(Color.BLUE,new CornerRadii(0), new Insets(0))));
		tilePane2.getChildren().addAll(bla);
		vbox1.getChildren().addAll(tilePane1, tilePane2);







		//add all the elements to border//
		border.add(upperleft, 0,0);
		border.add(comboBox, 3,0,1,1);
		border.add(vbox1,0, 2, 3, 3);



		return border;

	}
	public static void main(String[] args) {
		launch(args);
	}
}
