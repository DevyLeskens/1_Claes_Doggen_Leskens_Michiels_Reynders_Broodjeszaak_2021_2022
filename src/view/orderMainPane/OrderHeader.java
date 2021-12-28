package view.orderMainPane;

import controller.OrderViewController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.discountStrategies.DiscountStrategyEnum;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderHeader extends BorderPane {
    OrderViewController orderViewController;
    Button newOrder = new Button("New order");
    private Label followNumberLabel = new Label("Follownr: None");
    private static ChoiceBox choiceBox = new ChoiceBox();

    public OrderHeader(OrderViewController orderViewController) {
        //css
        this.orderViewController = orderViewController;
        newOrder.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5), new Insets(0))));
        newOrder.setFont(Font.font("Verdana", 25));
        newOrder.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        followNumberLabel.setFont(Font.font("Verdana", 20));
        choiceBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        choiceBox.setMinSize(100, 53);
        //css
        choiceBox.setItems(FXCollections.observableArrayList(orderViewController.getDiscountsEnum()));
        // properties
        System.out.println(DiscountStrategyEnum.getEnumFromString(orderViewController.getPreferredDiscountStrategy()));
        choiceBox.setValue(DiscountStrategyEnum.getEnumFromString(orderViewController.getPreferredDiscountStrategy()));
        newOrder.setOnAction(event -> {
            updateFollowNumber();
            ArrayList<String> dontChange = new ArrayList<>(Arrays.asList("New order", "To kitchen", "Pay"));
            OrderView.changeAllButtons(OrderView.vBox, false, dontChange);
            newOrder.setDisable(true);
        });

        this.setPadding(new Insets(5, 10, 7, 10));
        this.setLeft(newOrder);
        this.setCenter(followNumberLabel);
        this.setRight(choiceBox);

    }

    public static ChoiceBox getChoiceBox() {
        return choiceBox;
    }

    public void updateFollowNumber() {
        followNumberLabel.setText("Follownr: " + orderViewController.getfollownr());
    }
}
