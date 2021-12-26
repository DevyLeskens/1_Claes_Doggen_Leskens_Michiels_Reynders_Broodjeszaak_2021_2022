package view.orderMainPane.DetailsListAndButton;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class OrderDetailsListAndButton extends VBox {

    OrderViewController orderViewController;

    public OrderDetailsListAndButton(){
        this.setPadding(new Insets(0, 22,0, 30));
        this.setSpacing(30);
        this.setMinWidth(350);
        this.getChildren().addAll(new OrderDetailsList(), new CancelButton());

    }



}
