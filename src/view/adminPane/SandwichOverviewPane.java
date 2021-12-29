package view.adminPane;

import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SandwichOverviewPane extends GridPane {
    public static TableView sandwichStock;

    public SandwichOverviewPane(AdminViewController adminViewController) {
        sandwichStock = new TableView();
        OverviewPane.refresh(adminViewController.getSandwichDatabase(), sandwichStock);
        OverviewPane.setEqualColumns(new String[]{"Name", "price", "stock"}, sandwichStock);
        sandwichStock.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //css
        this.setPadding(new Insets(5, 5, 10, 30));
        this.setVgap(5);
        this.setHgap(5);
        sandwichStock.setEffect(new DropShadow(10, Color.BLACK));
        sandwichStock.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        // add to main
        this.add(sandwichStock, 0, 1, 1, 1);
    }

}
