package view.orderMainPane;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.OrderFacade;
import model.domain.Sandwich;
import model.domain.Topping;


public class OrderSandwichesAndToppings extends VBox {
    TilePane sandwiches = new TilePane();
    TilePane toppings = new TilePane();
    public OrderSandwichesAndToppings() {
        setSandwichesButtons();
        setToppingsButtons();
        //css
        this.setBackground(new Background(new BackgroundFill(Color.SKYBLUE, new CornerRadii(0), new Insets(0))));
        this.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        //css
        this.getChildren().addAll(sandwiches, toppings);
    }
    public void setSandwichesButtons(){
        for (Sandwich sandwich: OrderFacade.getInstance().getSandwichDatabase().getSandwichsorts().values()) {
            Button sandwichType = new Button(sandwich.getName());
            //css
            sandwichType.setMinWidth(105);
            sandwichType.setMinHeight(40);
            sandwichType.setBackground(new Background((new BackgroundFill(Color.WHITE,new CornerRadii(5),new Insets(0)))));
            sandwichType.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            sandwiches.setHgap(10);
            sandwiches.setVgap(10);
            sandwiches.setPadding(new Insets(10,10,10,10));
            //css
            sandwiches.getChildren().add(sandwichType);
        }
    }
    public void setToppingsButtons(){
        for (Topping toppping: OrderFacade.getInstance().getToppingDatabase().getToppingsorts().values()) {
            Button toppingButton = new Button(toppping.getName());
            //css
            toppingButton.setMinWidth(105);
            toppingButton.setMinHeight(40);
            toppingButton.setBackground(new Background(new BackgroundFill(Color.YELLOW,new CornerRadii(5),new Insets(0))));
            toppingButton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
            toppings.setHgap(10);
            toppings.setVgap(10);
            toppings.setPadding(new Insets(10,10,30,10));
            //css
            toppings.getChildren().add(toppingButton);
        }
    }

}
