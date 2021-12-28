package view.adminPane;


import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;



public class ToppingOverviewPane extends GridPane {
    public static TableView toppingStock;

    public ToppingOverviewPane(AdminViewController adminViewController) {
        toppingStock = new TableView();
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        Label label = new Label("Toppings:");
        label.setFont(new Font(20));
        this.add(label, 0, 0, 1, 1);
        OverviewPane.refresh(adminViewController.getToppingDatabase(), toppingStock);
        OverviewPane.setEqualColumns(new String[]{"name", "price", "stock"}, toppingStock);
        toppingStock.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        this.add(toppingStock, 0, 1, 1, 1);
    }


}
