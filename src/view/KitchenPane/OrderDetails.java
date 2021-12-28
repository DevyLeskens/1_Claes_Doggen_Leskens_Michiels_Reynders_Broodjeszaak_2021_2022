package view.KitchenPane;

import controller.KitchenViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.*;

public class OrderDetails extends VBox {
    KitchenViewController kitchenViewController;
    static Label followNumber;
    static int sandwichCount;
    static VBox sandwiches = new VBox();
    static HBox detailsOfOrder = new HBox();
    Label followNr = new Label("Follownr order:" + followNumber + "- Count sandwiches: " + sandwichCount);
    private static Label details = new Label("sandwich details");

    public OrderDetails(KitchenViewController kitchenViewController) {
        this.kitchenViewController = kitchenViewController;
        this.getChildren().addAll(followNr, details, detailsOfOrder);
        this.setPadding(new Insets(5, 0, 20, 10));
        this.setMinHeight(120);

    }


    public static void update(HashMap<String, Integer> order, boolean isInspected) {
        if (order == null || !isInspected) {
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




