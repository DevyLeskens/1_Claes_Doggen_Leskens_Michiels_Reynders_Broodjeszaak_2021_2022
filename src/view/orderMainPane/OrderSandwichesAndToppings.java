package view.orderMainPane;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.OrderFacade;
import model.OrderLine;
import model.domain.Sandwich;
import model.domain.Topping;
import view.orderMainPane.DetailsListAndButton.OrderDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class OrderSandwichesAndToppings extends VBox {
    private static int selectedColumnId = 0;
    private static ArrayList<Button> sandwichButtons = new ArrayList<>();
    private static ArrayList<Button> toppingButtons = new ArrayList<>();
    TilePane sandwiches = new TilePane();
    TilePane toppings = new TilePane();
    OrderViewController orderViewController;

    public OrderSandwichesAndToppings(OrderViewController orderViewController) {
        this.orderViewController = orderViewController;
        setSandwichesButtons();
        setToppingsButtons();
        updateStatusToppingButtons(orderViewController.getOrderFacade().getStockListToppings());
        updateStatusSandwichButtons(orderViewController.getOrderFacade().getStockListSandwiches());
        //css
        this.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        //add to root
        this.getChildren().addAll(sandwiches, toppings);
    }

    public void setSandwichesButtons() {
        for (Sandwich sandwich : OrderFacade.getInstance().getSandwichDatabase().getDatabase().values()) {
            Button sandwichType = new Button(sandwich.getName());
            sandwichButtons.add(sandwichType);

            //css
            sandwichType.setMinWidth(105);
            sandwichType.setMinHeight(40);
            sandwichType.setBackground(new Background((new BackgroundFill(Color.NAVAJOWHITE, new CornerRadii(5), new Insets(0)))));
            sandwichType.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            sandwiches.setHgap(10);
            sandwiches.setVgap(10);
            sandwiches.setPadding(new Insets(10, 10, 10, 10));
            sandwiches.setEffect(new DropShadow(2, Color.BLACK));

            //add to root
            sandwiches.getChildren().add(sandwichType);

            //action
            sandwichType.setOnAction(event -> {
                orderViewController.addOrderLine(sandwich.getName());
            });
        }
    }

    public void setToppingsButtons() {
        for (Topping topping : OrderFacade.getInstance().getToppingDatabase().getDatabase().values()) {
            Button toppingButton = new Button(topping.getName());
            toppingButtons.add(toppingButton);
            //css
            toppingButton.setMinWidth(105);
            toppingButton.setMinHeight(40);
            toppingButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGOLDENRODYELLOW, new CornerRadii(5), new Insets(0))));
            toppingButton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            toppings.setHgap(10);
            toppings.setVgap(10);
            toppings.setPadding(new Insets(10, 10, 30, 10));
            toppings.setEffect(new DropShadow(2, Color.BLACK));
            //add to root
            toppings.getChildren().add(toppingButton);

            toppingButton.setOnAction(event -> orderViewController.addTopping(OrderSandwichesAndToppings.getSelectedColumnId(), topping.getName()));
        }
    }

    public static void updateStatusSandwichButtons(HashMap<String, Integer> stockListSandwiches) {
        for (Button sandwichButton : sandwichButtons) {
            if (stockListSandwiches.get(sandwichButton.getText()) <= 0) {
                sandwichButton.setDisable(true);
            }else{
                sandwichButton.setDisable(false);
            }
        }
    }

    public static void updateStatusToppingButtons(HashMap<String, Integer> stockListToppings) {
        for (Button toppingButton : toppingButtons) {
            if (stockListToppings.get(toppingButton.getText()) <= 0) {
                toppingButton.setDisable(true);
            }else{
                toppingButton.setDisable(false);
            }
        }
    }

    public static void setSelectedColumnId(int newSelectedColumnId) {
        selectedColumnId = newSelectedColumnId;
    }

    public static int getSelectedColumnId() {
        OrderLine orderLine = (OrderLine) OrderDetails.tableView.getSelectionModel().getSelectedItem();
        OrderSandwichesAndToppings.setSelectedColumnId(OrderDetails.getIdOfTable(orderLine, (Collection<OrderLine>) OrderDetails.tableView.getItems()));
        return selectedColumnId;
    }
}
