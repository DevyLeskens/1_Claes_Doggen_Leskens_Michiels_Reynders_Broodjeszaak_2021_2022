package view.orderMainPane;

import controller.OrderViewController;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.discountStrategies.DiscountStrategyEnum;
import view.KitchenPane.KitchenView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FooterToKitchenAndPay extends HBox {
    Button pay = new Button("Pay");
    Button toKitchen = new Button("To kitchen");

    public FooterToKitchenAndPay(OrderViewController orderViewController){
        this.setSpacing(15);
        pay.setFont(Font.font("Verdana", 20));
        pay.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        toKitchen.setFont(Font.font("Verdana", 20));
        toKitchen.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        this.getChildren().addAll(pay,toKitchen);

        toKitchen.setOnAction(event -> {
            orderViewController.toKitchen();
            ArrayList<String> dontchange = new ArrayList<>(Arrays.asList("New order"));
            OrderView.changeallbuttons(OrderView.vBox,true, dontchange);
        });

        pay.setOnAction(event -> {
            ArrayList<String> dontchange = new ArrayList<>(Collections.singletonList("To kitchen"));
            OrderView.changeallbuttons(OrderView.vBox, true, dontchange);
            orderViewController.pay();
        });
    }
}
