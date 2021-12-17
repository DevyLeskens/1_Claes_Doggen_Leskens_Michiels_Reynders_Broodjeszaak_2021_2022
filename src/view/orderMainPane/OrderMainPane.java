package view.orderMainPane;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.OrderFacade;
import view.orderMainPane.DetailsListAndButton.OrderDetails;

public class OrderMainPane extends VBox {
    Label countSandwiches = new Label("Sandwich count:");


    public OrderMainPane(OrderFacade orderFacade){
        this.getChildren().addAll(new OrderHeader(), new OrderSandwichesAndToppings(), countSandwiches, new OrderDetails(), new OrderFooter());

    }
}
