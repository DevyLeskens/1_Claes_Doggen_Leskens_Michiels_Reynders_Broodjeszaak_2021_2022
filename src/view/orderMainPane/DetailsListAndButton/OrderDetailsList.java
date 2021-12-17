package view.orderMainPane.DetailsListAndButton;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class OrderDetailsList extends VBox {
    Label select = new Label("select line in list");
    Button addSameSandwich= new Button("Add identical sandwich");
    Button deleteSandwich = new Button("Delete sandwich");

    public OrderDetailsList(){
        this.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(0), new Insets(0))));
        this.getChildren().addAll(select, addSameSandwich, deleteSandwich );

    }

}
