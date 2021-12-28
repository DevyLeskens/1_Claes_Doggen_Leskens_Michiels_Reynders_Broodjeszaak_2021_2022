package view.adminPane;

import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SandwichOverviewPane extends GridPane {
    public static TableView sandwichStock;

    public SandwichOverviewPane(AdminViewController adminViewController) {
        sandwichStock = new TableView();
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        Label label = new Label("Sandwiches:");
        label.setFont(new Font(20));
        this.add(label, 0, 0, 1, 1);
        OverviewPane.refresh(adminViewController.getSandwichDatabase(), sandwichStock);
        OverviewPane.setEqualColumns(new String[]{"Name", "price", "stock"}, sandwichStock);
        sandwichStock.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.add(sandwichStock, 0, 1, 1, 1);
    }

}
