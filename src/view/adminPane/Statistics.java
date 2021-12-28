package view.adminPane;

import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Order;
import model.OrderFacade;
import model.OrderLine;
import model.domain.Sandwich;
import model.domain.Topping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Statistics extends VBox {
    Label sandwiches  = new Label("Revenue statistics sandwiches (in parts)");
    Label toppings = new Label("Revenue statistics toppings (in parts)");
    static VBox sandwichesStats = new VBox();
    static VBox toppingsStats = new VBox();
    HBox sandwichesFullStats = new HBox();
    HBox toppingFullStats = new HBox();
    AdminViewController adminViewController;

    public Statistics(AdminViewController adminViewController){
        this.adminViewController = adminViewController;
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

    public static void setData(AdminViewController adminViewController) {
        toppingsStats.getChildren().clear();
        sandwichesStats.getChildren().clear();

        for (Map.Entry<String, HashMap<String, Integer>> productmap: adminViewController.getSoldOrders().entrySet() ) {
            for (Map.Entry<String, Integer> product: productmap.getValue().entrySet()) {
                BorderPane borderPane = new BorderPane();
                String name = product.getKey();
                Label sandwichtype = new Label(name);
                String sandwichCount = String.valueOf(product.getValue());
                Label soldCount = new Label(sandwichCount);
                borderPane.setLeft(sandwichtype);
                borderPane.setRight(soldCount);
                borderPane.setPadding(new Insets(5, 0, 5, 10));
                borderPane.setMinSize(150, 20);
                if (productmap.getKey().equals("Toppings")) {
                    toppingsStats.getChildren().add(borderPane);
                } else {
                    sandwichesStats.getChildren().add(borderPane);
                }
            }
       }
    }

    public static void setSandwiches(Sandwich sandwich){

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

    public static void setToppings(ArrayList<Topping> toppings){
        for (Topping topping : toppings) {
            BorderPane borderPane = new BorderPane();
            Label toppingtype= new Label(topping.getName());
            String toppingCount = String.valueOf(topping);
            Label soldCount = new Label(toppingCount);
            borderPane.setLeft(toppingtype);
            borderPane.setRight(soldCount);
            borderPane.setPadding(new Insets(5,0,5,10));
            borderPane.setMinSize(150, 20);
            toppingsStats.getChildren().add(borderPane);
        }
    }
    public void setSandwichesDefault(){
        // TODO
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

    public void setToppingsDefault(){
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