package view.orderMainPane.DetailsListAndButton;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class OrderDetailsListAndButton extends VBox {

    OrderViewController orderViewController;

    public OrderDetailsListAndButton(OrderViewController orderViewController) {
        //csss
        this.setPadding(new Insets(0, 22, 0, 30));
        this.setSpacing(30);
        this.setMinWidth(350);

        //add to root
        this.getChildren().addAll(new OrderDetailsList(orderViewController), new CancelButton(orderViewController));
    }
}
