package view.orderMainPane.DetailsListAndButton;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import view.orderMainPane.OrderSandwichesAndToppings;

public class OrderDetailsList extends VBox {
    OrderViewController orderViewController;
    Label select = new Label("select line in list");
    Button addSameSandwich= new Button("Add identical sandwich");
    Button deleteSandwich = new Button("Delete sandwich");


    public OrderDetailsList(){
        //css
        select.setMaxWidth(Double.MAX_VALUE);
        //select.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(0), new Insets(0))));
        select.setPadding(new Insets(5,0,20,5));
        select.setFont(Font.font("Verdana",20));
        addSameSandwich.setMaxWidth(Double.MAX_VALUE);
        addSameSandwich.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        deleteSandwich.setMaxWidth(Double.MAX_VALUE);
        deleteSandwich.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        this.setPadding(new Insets(10,10,10,10));
        this.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        this.setSpacing(10);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        this.setEffect(new DropShadow(10, Color.BLACK));
        //this.addSameSandwich.setOnAction(event -> orderViewController.addIdenticallSandwich(OrderSandwichesAndToppings.getSelectedColumnId(), topping.getName()));

        this.getChildren().addAll(select, addSameSandwich, deleteSandwich );
    }

}
