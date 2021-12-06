package view.orderMainPane;

import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import model.OrderFacade;

public class OrderMainPane extends GridPane {
    public OrderMainPane(OrderFacade orderFacade){
        FlowPane header = new FlowPane();
        header.getChildren().addAll(new Button("New order"), new Label("Follownr:"), new ComboBox());
        this.getChildren().addAll(header);


    }
}
