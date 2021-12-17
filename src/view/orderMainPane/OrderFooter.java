package view.orderMainPane;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class OrderFooter extends HBox {
    Button endOrder= new Button("End order");
    Label bill = new Label("Amount:");
    Button pay = new Button("pay");
    Button toKitchen = new Button("To kitchen");

    public OrderFooter(){
        this.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(0), new Insets(0))));
        this.getChildren().addAll(endOrder, bill, pay, toKitchen);
    }
}
