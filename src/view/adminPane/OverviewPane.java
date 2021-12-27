package view.adminPane;

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

public abstract class OverviewPane<E> extends GridPane {

    protected ObservableList<E> item;
    protected final TableView<E> tableView;

    public OverviewPane(String name, Collection<E> values,  String[] names) {

        this.tableView = new TableView<E>();
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        Label label = new Label(name + ":");
        label.setFont(new Font(20));
        this.add(label, 0, 0, 1, 1);
        refresh(values);
        this.setEqualColumns(names, tableView);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.add(tableView,0,1,1,1);

    }

    public void setEqualColumns(String[] names, TableView<E> tableview){
        for (String name: names){
            TableColumn col = new TableColumn<>(name.substring(0,1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT));
            col.setMinWidth(50);
            col.setCellValueFactory(new PropertyValueFactory<>(name));
            tableview.getColumns().add(col);
        }
    }
    public void refresh(Collection<E> lijst){
        item = FXCollections.observableArrayList(lijst);
        this.tableView.setItems(item);
        tableView.refresh();
    }

}
