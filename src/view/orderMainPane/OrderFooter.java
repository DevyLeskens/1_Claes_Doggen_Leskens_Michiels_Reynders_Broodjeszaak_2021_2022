package view.orderMainPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class OrderFooter extends HBox {
    Button endOrder= new Button("End order");
    Label bill = new Label("Amount:");
    Button pay = new Button("pay");
    Button toKitchen = new Button("To kitchen");
    public OrderFooter(){
        this.getChildren().addAll(endOrder, bill, pay, toKitchen);
    }
}
