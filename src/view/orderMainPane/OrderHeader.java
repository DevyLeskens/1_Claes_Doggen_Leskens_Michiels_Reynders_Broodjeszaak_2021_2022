package view.orderMainPane;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OrderHeader extends BorderPane {
    OrderViewController orderViewController;
    Button newOrder = new Button("New order");
    Label followNr =  new Label("Follownr");
    ComboBox combobox= new ComboBox();

    public OrderHeader(OrderViewController orderViewController){
        //css
        newOrder.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY,new CornerRadii(5),new Insets(0))));
        newOrder.setFont(Font.font("Verdana",25));
        newOrder.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        followNr.setFont(Font.font("Verdana",20));
        //css
        this.setPadding(new Insets(3,0,7,3));
        this.setLeft(newOrder);
        this.setCenter(followNr);
        this.setRight(combobox);
    }


}
