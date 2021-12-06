package view.orderMainPane;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.OrderFacade;
import view.adminPane.SandwichOverviewPane;
import view.adminPane.ToppingOverviewPane;

public class OrderMainPane extends GridPane {
    public OrderMainPane(OrderFacade orderFacade){
        OrderHeader orderHeader = new OrderHeader();
        this.getChildren().add(orderHeader);
    }
}
