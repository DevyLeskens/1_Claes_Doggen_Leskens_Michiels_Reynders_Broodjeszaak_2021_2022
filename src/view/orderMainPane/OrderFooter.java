package view.orderMainPane;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OrderFooter extends HBox {
    OrderViewController orderViewController;
    Button endOrder= new Button("End order");
    Label bill = new Label("Amount:");
    Button pay = new Button("Pay");
    Button toKitchen = new Button("To kitchen");

    public OrderFooter(OrderViewController orderViewController){
        //css
        endOrder.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5), new Insets(0))));
        endOrder.setFont(Font.font("Verdana",15));
        endOrder.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        bill.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(5), new Insets(0))));
        bill.setFont(Font.font("Verdana",25));
        pay.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5), new Insets(0))));
        pay.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        pay.setMinWidth(80);
        toKitchen.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5), new Insets(0))));
        toKitchen.setTextFill(Color.GREY);
        toKitchen.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        toKitchen.setMinWidth(80);
        this.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(0), new Insets(0))));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        //css
        this.getChildren().addAll(endOrder, bill, pay, toKitchen);
    }
}
