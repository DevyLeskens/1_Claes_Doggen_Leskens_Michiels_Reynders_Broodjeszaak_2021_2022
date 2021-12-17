package view.orderMainPane;

import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class OrderSandwichesAndToppings extends VBox {

    public OrderSandwichesAndToppings() {
        TilePane sandwiches = new TilePane();
        TilePane toppings = new TilePane();
        this.getChildren().addAll(sandwiches, toppings);
    }

}
