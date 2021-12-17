package view.orderMainPane.DetailsListAndButton;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class OrderDetailsListAndButton extends VBox {
    Button cancelOrder = new Button("cancel order");
    public OrderDetailsListAndButton(){
        this.getChildren().addAll(new OrderDetailsList(), cancelOrder);
    }

}
