package view.KitchenPane;

import controller.KitchenViewController;
import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Order;
import model.OrderLine;

import java.util.HashMap;

public class OrderDetails extends VBox {

    Label follownr = new Label("Follownr order:" + "- Count sandwiches: ");
    private static Label details = new Label("details broodje");

    public OrderDetails(KitchenViewController kitchenViewController){
        this.getChildren().addAll(follownr, details);
        this.setPadding(new Insets(0,0,20,10));
        this.setMinHeight(120);
    }

    public static void update(HashMap<String, Integer> order, boolean isinspected){
        if(order == null || !isinspected){
            details.setText("");
        }else {
            details.setText((order).toString());
        }

    }

}
