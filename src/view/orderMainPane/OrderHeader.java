package view.orderMainPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OrderHeader extends HBox {
    Button newOrder = new Button("New order");
    Label followNr =  new Label("Follownr");
    ComboBox combobox= new ComboBox();

    public OrderHeader(){
        //css
        newOrder.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,new CornerRadii(5),new Insets(0))));
        newOrder.setFont(Font.font("Verdana",25));
        newOrder.setTextFill(Color.GREY);
        newOrder.setAlignment(Pos.BASELINE_LEFT);
        followNr.setFont(Font.font("Verdana",25));
        followNr.setPadding(new Insets(10,10,10,20));
        //css
        this.getChildren().addAll(newOrder, followNr, combobox);
    }


}
