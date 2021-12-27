package view.orderMainPane.DetailsListAndButton;

import controller.OrderViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.OrderLine;
import view.orderMainPane.DetailsListAndButton.OrderDetailsListAndButton;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class OrderDetails extends BorderPane {
    private OrderViewController orderViewController;
    public static TableView tableView;
    public OrderDetails(OrderViewController orderViewController){
        this.tableView = new TableView<>();
        this.setPadding(new Insets(5, 5, 15, 10));
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setMinWidth(350);
        tableView.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        tableView.setEffect(new DropShadow(10, Color.BLACK));
        this.setLeft(tableView);
        this.setRight(new OrderDetailsListAndButton(orderViewController));

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
    public void refresh(Collection lijst){
        ObservableList item = FXCollections.observableArrayList(lijst);
        this.tableView.setItems(item);
        tableView.refresh();
    }
    public static int getIdOfTable(OrderLine neworderLine, Collection<OrderLine> lijst){
        int i = 0;
        for (OrderLine orderline: lijst) {
            if(neworderLine == orderline){ return i; }
            i++;
        }
        return 0;
    }

}
