package view.adminPane;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.OrderFacade;
import model.domain.Sandwich;
import model.domain.Topping;

import java.util.Collection;

public class Statistics extends VBox {
    Label sandwiches  = new Label("Revenue statistics sandwiches (in parts)");
    Label toppings = new Label("Revenue statistics toppings (in parts)");
    VBox sandwichesStats = new VBox();
    VBox toppingsStats = new VBox();
    HBox sandwichesFullStats = new HBox();
    HBox toppingFullStats = new HBox();

    public Statistics(){
        setSandwiches();
        setToppings();
        sandwichesFullStats.getChildren().addAll(sandwichesStats);
        toppingFullStats.getChildren().addAll((toppingsStats));
        //add to main
        this.getChildren().addAll(sandwiches,sandwichesFullStats, toppings, toppingFullStats);
        //css
        sandwiches.setPadding(new Insets(10, 10, 10, 10));
        toppings.setPadding(new Insets(10, 10, 10, 10));
        sandwiches.setFont(Font.font("Verdana", 20));
        toppings.setFont(Font.font("Verdana", 20));
        sandwichesFullStats.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        toppingFullStats.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        sandwichesFullStats.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        toppingFullStats.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        sandwichesFullStats.setEffect(new DropShadow(10, Color.BLACK));
        toppingFullStats.setEffect(new DropShadow(10, Color.BLACK));
    }

    public void setSandwiches(){
        for (Sandwich sandwich : OrderFacade.getInstance().getSandwichDatabase().getSandwichsorts().values()) {
            BorderPane borderPane = new BorderPane();
            String name = sandwich.getName();
            Label sandwichtype = new Label(name);
            String sandwichCount = String.valueOf(sandwich.getSold());
            Label soldCount = new Label(sandwichCount);
            borderPane.setLeft(sandwichtype);
            borderPane.setRight(soldCount);
            borderPane.setPadding(new Insets(5,0,5,10));
            borderPane.setMinSize(150, 20);
            sandwichesStats.getChildren().add(borderPane);
        }
    }

    public void setToppings(){
        for (Topping topping : OrderFacade.getInstance().getToppingDatabase().getToppingsorts().values()) {
            BorderPane borderPane = new BorderPane();
            Label toppingtype= new Label(topping.getName());
            String toppingCount = String.valueOf(topping.getSold());
            Label soldCount = new Label(toppingCount);
            borderPane.setLeft(toppingtype);
            borderPane.setRight(soldCount);
            borderPane.setPadding(new Insets(5,0,5,10));
            borderPane.setMinSize(150, 20);
            toppingsStats.getChildren().add(borderPane);
        }
    }
}
