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
    static int sandwichCount;
    static VBox sandwiches = new VBox();
    static HBox detailsOfOrder = new HBox();
    static Label followNr = new Label("Follownr order:" + "None" + "- Count sandwiches: " + sandwichCount);
    private static Label details = new Label("details broodje");

    public OrderDetails(KitchenViewController kitchenViewController) {
        this.kitchenViewController = kitchenViewController;
        this.getChildren().addAll(followNr, details, detailsOfOrder);
        this.setPadding(new Insets(5, 0, 20, 10));
        this.setMinHeight(120);

    }


    public static void update(int orderNumber, HashMap<OrderLine, Integer> order, boolean isInspected, KitchenViewController kitchenViewController) {
        if (order == null || !isInspected) {
            details.setText("");
            followNr.setText("Follownr order: No order - Count sandwiches: " + kitchenViewController.getOrderCount());

        } else {
            details.setText(OrderDetails.orderToString(order));
            followNr.setText("Follownr order: " + orderNumber + " - Count sandwiches: " + kitchenViewController.getOrderCount());
        }
    }

    private static String orderToString(HashMap<OrderLine, Integer> order) {
        StringBuilder displayedOrder = new StringBuilder();
        for (Map.Entry<OrderLine, Integer> entry : order.entrySet()) {
            displayedOrder.append(entry.getValue()).append(" x ").append(entry.getKey().getSandwich()).append(":");
            if (entry.getKey().getToppingsSort().size() != 0) {
                for (Map.Entry<String, Integer> orderLine : entry.getKey().getToppingsAsStringMap().entrySet()) {
                    displayedOrder.append(", ").append(orderLine.getValue()).append(" x ").append(orderLine.getKey());
                }
            } else {
                displayedOrder.append(" ZONDER toppings!");
            }
            displayedOrder.append("\n");
        }
        return displayedOrder.toString();
    }


}




