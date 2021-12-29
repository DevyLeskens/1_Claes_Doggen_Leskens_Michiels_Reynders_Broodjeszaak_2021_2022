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



public class ToppingOverviewPane extends GridPane {
    public static TableView toppingStock;

    public ToppingOverviewPane(AdminViewController adminViewController) {
        toppingStock = new TableView();
        OverviewPane.refresh(adminViewController.getToppingDatabase(), toppingStock);
        OverviewPane.setEqualColumns(new String[]{"name", "price", "stock"}, toppingStock);
        toppingStock.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        //css
        this.setPadding(new Insets(5, 5, 10, 85));
        this.setVgap(5);
        this.setHgap(5);
        toppingStock.setEffect(new DropShadow(10, Color.BLACK));
        toppingStock.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));

        //add to root
        this.add(toppingStock, 0, 1, 1, 1);
    }


}
