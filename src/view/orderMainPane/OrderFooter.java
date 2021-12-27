package view.orderMainPane;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OrderFooter extends BorderPane {
    OrderViewController orderViewController;
    Button endOrder= new Button("End order");
    private double amount = 0;
    private static Label bill = new Label("Amount: " + 0);

    public OrderFooter(OrderViewController orderViewController){
        //css
        endOrder.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5), new Insets(0))));
        endOrder.setFont(Font.font("Verdana",20));
        endOrder.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        bill.setFont(Font.font("Verdana",20));
        this.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        //css
        this.setPadding(new Insets(5,10,5,10));
        this.setLeft(endOrder);
        this.setCenter(bill);
        this.setRight(new FooterToKitchenAndPay());
    }
    public static void updateAmount(double amount){
        bill.setText("Amount: " + amount);
    }
}
