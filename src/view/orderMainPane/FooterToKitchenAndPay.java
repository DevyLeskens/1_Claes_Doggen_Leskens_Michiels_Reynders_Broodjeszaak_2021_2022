package view.orderMainPane;

import controller.OrderViewController;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FooterToKitchenAndPay extends HBox {
    Button pay = new Button("Pay");
    Button toKitchen = new Button("To kitchen");

    public FooterToKitchenAndPay(OrderViewController orderViewController) {
        //css
        this.setSpacing(15);
        pay.setFont(Font.font("Verdana", 20));
        pay.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        toKitchen.setFont(Font.font("Verdana", 20));
        toKitchen.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));

        //add to root
        this.getChildren().addAll(pay, toKitchen);

        //action
        toKitchen.setOnAction(event -> {
            orderViewController.updateBase();
            orderViewController.toKitchen();
            ArrayList<String> dontChange = new ArrayList<>(Arrays.asList("New order"));
            OrderView.changeAllButtons(OrderView.vBox, true, dontChange);
        });

        pay.setOnAction(event -> {
            ArrayList<String> dontChange = new ArrayList<>(Collections.singletonList("To kitchen"));
            OrderView.changeAllButtons(OrderView.vBox, true, dontChange);
            orderViewController.pay();
        });
    }
}
