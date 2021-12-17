package view.orderMainPane;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.OrderFacade;

public class OrderMainPane extends VBox {
    Label countSandwiches = new Label("Sandwich count:");


    public OrderMainPane(OrderFacade orderFacade){
        this.getChildren().addAll(new OrderHeader(), new OrderSandwichesAndToppings(), countSandwiches, new OrderDetails(), new OrderFooter());

    }
}
