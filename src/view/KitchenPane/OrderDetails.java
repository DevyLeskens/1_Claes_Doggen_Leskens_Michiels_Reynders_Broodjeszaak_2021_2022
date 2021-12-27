package view.KitchenPane;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Order;
import model.OrderLine;

public class OrderDetails extends VBox {

    Label follownr = new Label("Follownr order:" + "- Count sandwiches: ");
    Label sandwiches = new Label("details broodje");

    public OrderDetails(){
        this.getChildren().addAll(follownr, sandwiches);
        this.setPadding(new Insets(0,0,20,10));
        this.setMinHeight(120);
    }
}
