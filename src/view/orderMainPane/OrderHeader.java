package view.orderMainPane;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class OrderHeader extends HBox {
    Button newOrder = new Button("New order");
    Label followNr =  new Label("Follownr");
    ComboBox combobox= new ComboBox();

    public OrderHeader(){
        this.getChildren().addAll(newOrder, followNr, combobox);
    }


}
