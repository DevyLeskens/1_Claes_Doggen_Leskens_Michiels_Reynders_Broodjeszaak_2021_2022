package view.orderMainPane.DetailsListAndButton;

import controller.OrderViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.Order;
import model.OrderLine;
import view.orderMainPane.DetailsListAndButton.OrderDetailsListAndButton;
import view.orderMainPane.OrderSandwichesAndToppings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class OrderDetails extends HBox {
    private OrderViewController orderViewController;
    public static TableView tableView;
    public OrderDetails(OrderViewController orderViewController){
        this.tableView = new TableView<>();
        this.setPadding(new Insets(5, 5, 5, 5));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.getChildren().addAll(tableView, new OrderDetailsListAndButton());
    }

    public void fillTable(List<OrderLine> orderLines) {
        refresh(orderLines);
        if(tableView.getColumns().size() == 0) {
            this.setEqualColumns(new String[]{"sandwichname", "toppingnames"}, tableView);
        }
    }
    public void setEqualColumns(String[] names, TableView tableview){
        for (String name: names){
            TableColumn col = new TableColumn<>(name.substring(0,1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT));
            col.setMinWidth(50);
            col.setCellValueFactory(new PropertyValueFactory<>(name));
            tableview.getColumns().add(col);

        }
    }
    public static void refresh(Collection<OrderLine> lijst){
        ObservableList<OrderLine> item = FXCollections.observableArrayList(lijst);
        OrderLine orderLine = (OrderLine) tableView.getSelectionModel().getSelectedItem();
        OrderSandwichesAndToppings.setSelectedColumnId(getIdOfTable(orderLine ,  lijst));
        tableView.setItems(item);
        System.out.println(OrderSandwichesAndToppings.getSelectedColumnId());
        tableView.refresh();
    }
    // niet meest efficient maar wel duidelijk
    public static int getIdOfTable(OrderLine neworderLine, Collection<OrderLine> lijst){
        int i = 0;
        for (OrderLine orderline: lijst) {
            if(neworderLine == orderline){ return i; }
            i++;
        }
        return 0;
    }

}
