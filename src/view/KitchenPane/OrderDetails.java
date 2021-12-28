package view.KitchenPane;

import controller.KitchenViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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


    public static void update(HashMap<String, Integer> order, boolean isinspected) {
        if (order == null || !isinspected) {
            details.setText("");
        } else {
            details.setText((order).toString());

        }
    }

    public static String toString(HashMap<String, Integer> order){
        for (String key:order.keySet()) {

        }
    }




}




