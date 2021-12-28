package view.orderMainPane.DetailsListAndButton;

import controller.OrderViewController;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import view.orderMainPane.OrderView;

import java.util.ArrayList;
import java.util.Arrays;

public class CancelButton extends BorderPane {
    Button cancelOrder = new Button("cancel order");

    public CancelButton(OrderViewController orderViewController) {
        cancelOrder.setFont(Font.font("Verdana", 15));
        this.setCenter(cancelOrder);
        cancelOrder.setOnAction(event -> {
            ArrayList<String> dontChange = new ArrayList<>(Arrays.asList("New order"));
            OrderView.changeAllButtons(OrderView.vBox, true, dontChange);
            orderViewController.cancelOrder();
            OrderView.resetLabel();
        });

    }
}
