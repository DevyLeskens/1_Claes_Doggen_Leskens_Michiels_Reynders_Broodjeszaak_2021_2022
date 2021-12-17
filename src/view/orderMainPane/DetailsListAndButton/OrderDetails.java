package view.orderMainPane.DetailsListAndButton;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import view.orderMainPane.DetailsListAndButton.OrderDetailsListAndButton;

public class OrderDetails extends HBox {
    protected TableView tableView;
    public OrderDetails(){
        this.tableView = new TableView<>();
        this.setPadding(new Insets(5, 5, 5, 5));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.getChildren().addAll(tableView, new OrderDetailsListAndButton());



    }
}
