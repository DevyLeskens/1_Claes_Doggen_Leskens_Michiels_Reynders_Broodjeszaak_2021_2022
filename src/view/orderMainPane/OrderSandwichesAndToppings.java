package view.orderMainPane;

import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import model.OrderFacade;
import model.domain.Sandwich;
import model.domain.Topping;


public class OrderSandwichesAndToppings extends VBox {
    TilePane sandwiches = new TilePane();
    TilePane toppings = new TilePane();
    public OrderSandwichesAndToppings() {
        setSandwichesButtons();
        setToppingsButtons();
        this.getChildren().addAll(sandwiches, toppings);
    }
    public void setSandwichesButtons(){
        for (Sandwich sandwich: OrderFacade.getInstance().getSandwichDatabase().getSandwichsorts().values()) {
            Button sandwichType = new Button(sandwich.getName());
            sandwiches.getChildren().add(sandwichType);
        }
    }
    public void setToppingsButtons(){
        for (Topping toppping: OrderFacade.getInstance().getToppingDatabase().getToppingsorts().values()) {
            Button toppingButton = new Button(toppping.getName());
            toppings.getChildren().add(toppingButton);
        }
    }

}
