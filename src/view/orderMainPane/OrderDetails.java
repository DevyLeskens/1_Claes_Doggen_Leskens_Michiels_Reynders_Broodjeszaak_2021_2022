package view.orderMainPane;

import javafx.geometry.Insets;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class OrderDetails extends HBox {
    protected TableView tableView;
    public OrderDetails(){
        this.tableView = new TableView<>();
        this.setPadding(new Insets(5, 5, 5, 5));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.getChildren().addAll(tableView, new OrderDetailsListAndButton());


    }
}
