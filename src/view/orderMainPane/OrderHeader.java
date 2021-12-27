package view.orderMainPane;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.discountStrategies.DiscountStrategyEnum;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

public class OrderHeader extends BorderPane {
    OrderViewController orderViewController;
    Button newOrder = new Button("New order");
    Label followNr =  new Label("Follownr:");
    private static ChoiceBox choiceBox = new ChoiceBox();

    public OrderHeader(OrderViewController orderViewController){
        //css
        newOrder.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,new CornerRadii(5),new Insets(0))));
        newOrder.setFont(Font.font("Verdana",25));
        newOrder.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        followNr.setFont(Font.font("Verdana",20));
        choiceBox.setValue("Add cheapest sandwich");
        choiceBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        choiceBox.setMinSize(100, 53);
        //css
        DiscountStrategyEnum[] discounts = orderViewController.getDiscounts();
        for (DiscountStrategyEnum discount: orderViewController.getDiscounts()) {
            choiceBox.getItems().add(discount);
        }
        // properties
        choiceBox.setValue(discounts[0]);
        newOrder.setOnAction(event -> {
            ArrayList<String> dontchange = new ArrayList<>(Arrays.asList("New order", "To kitchen"));
            OrderView.changeallbuttons(OrderView.vBox, false, dontchange);
            newOrder.setDisable(true);
        });

        this.setPadding(new Insets(5,10,7,10));
        this.setLeft(newOrder);
        this.setCenter(followNr);
        this.setRight(choiceBox);

    }

    public static ChoiceBox getChoiceBox() {
        return choiceBox;
    }
}
