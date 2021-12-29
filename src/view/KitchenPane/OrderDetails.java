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
    static int sandwichcount;
    static VBox sandwiches = new VBox();
    static HBox detailsOforder = new HBox();
    static Label follownr = new Label("Follownr order:" + "None" + "- Count sandwiches: " + sandwichcount);
    private static Label details = new Label("details broodje");

    public OrderDetails(KitchenViewController kitchenViewController) {
        this.kitchenViewController = kitchenViewController;
        this.getChildren().addAll(follownr, details, detailsOforder);
        this.setPadding(new Insets(5, 0, 20, 10));
        this.setMinHeight(120);

    }


    public static void update(int orderNumber, HashMap<OrderLine, Integer> order, boolean isinspected, KitchenViewController kitchenViewController) {
        if (order == null || !isinspected) {
            details.setText("");
            follownr.setText("Follownr order: No order - Count sandwiches: " + kitchenViewController.getOrderCount());

        } else {
            details.setText(OrderDetails.orderToString(order));
            follownr.setText("Follownr order: " + orderNumber + " - Count sandwiches: " + kitchenViewController.getOrderCount());
        }
    }

    private static String orderToString(HashMap<OrderLine, Integer> order){
        StringBuilder displayedorder = new StringBuilder();
        for (Map.Entry<OrderLine, Integer> entry:order.entrySet()) {
            displayedorder.append(entry.getValue()).append(" x ").append(entry.getKey().getSandwich()).append(":");
            if(entry.getKey().getToppingssort().size() != 0){
            for (Map.Entry<String, Integer> ordeline : entry.getKey().getToppingsAsStringMap().entrySet()) {
                displayedorder.append(ordeline.getValue()).append(" x ").append(ordeline.getKey()).append(", ");
            }}else {
                displayedorder.append(" ZONDER toppings!");
            }
            displayedorder.append("\n");
        }
        return displayedorder.toString();
    }




}




