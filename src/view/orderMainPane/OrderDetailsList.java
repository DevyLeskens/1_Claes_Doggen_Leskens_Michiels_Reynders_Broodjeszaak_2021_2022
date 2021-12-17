package view.orderMainPane;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class OrderDetailsList extends VBox {
    Label select = new Label("select line in list");
    Button addSameSandwich= new Button("Add identical sandwich");
    Button deleteSandwich = new Button("Delete sandwich");

    public OrderDetailsList(){
        this.getChildren().addAll(select, addSameSandwich, deleteSandwich );

    }
}
