package view.KitchenPane;

import controller.KitchenViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.OrderLine;

import java.util.*;

public class OrderDetails extends VBox {
    KitchenViewController kitchenViewController;
    static Label follownumber;
    static int sandwichcount;
    static VBox sandwiches = new VBox();
    static HBox detailsOforder = new HBox();
    Label follownr = new Label("Follownr order:" + follownumber + "- Count sandwiches: " + sandwichcount);
    private static Label details = new Label("details broodje");

    public OrderDetails(KitchenViewController kitchenViewController) {
        this.kitchenViewController = kitchenViewController;
        this.getChildren().addAll(follownr, details, detailsOforder);
        this.setPadding(new Insets(5, 0, 20, 10));
        this.setMinHeight(120);

    }


    public static void update(HashMap<OrderLine, Integer> order, boolean isinspected) {
        if (order == null || !isinspected) {
            details.setText("");
        } else {
            details.setText(OrderDetails.orderToString(order));
        }
    }

    private static String orderToString(HashMap<OrderLine, Integer> order){
        StringBuilder lol = new StringBuilder();
        for (Map.Entry<OrderLine, Integer> entry:order.entrySet()) {
              lol.append(entry.getValue()).append(" x ").append(entry.getKey()).append("\n");
        }
        return lol.toString();
    }




}




