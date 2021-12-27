package view.adminPane;

import controller.AdminViewController;
import controller.OrderViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.Collection;
import java.util.Locale;

public class OverviewPane {

    public static void setEqualColumns(String[] names, TableView tableview){
        for (String name: names){
            TableColumn col = new TableColumn<>(name.substring(0,1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT));
            col.setMinWidth(50);
            col.setCellValueFactory(new PropertyValueFactory<>(name));
            tableview.getColumns().add(col);
        }
    }
    public static void update(AdminViewController adminViewController){
        refresh(adminViewController.getSandwichDatabase(), SandwichOverviewPane.sandwichStock);
        refresh(adminViewController.getToppingDatabase(), ToppingOverviewPane.toppingStock);
    }
    public static void refresh(Collection lijst , TableView tableView){
        ObservableList item = FXCollections.observableArrayList(lijst);
        tableView.setItems(item);
        tableView.refresh();
    }

}
