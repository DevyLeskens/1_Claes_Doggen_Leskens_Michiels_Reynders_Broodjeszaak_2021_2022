package view.orderMainPane;

import controller.AdminViewController;
import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.OrderLine;
import model.states.StateInWait;
import view.adminPane.AdminMainPane;
import view.orderMainPane.DetailsListAndButton.OrderDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderView {
    public static VBox vBox = new VBox();
    private Stage stage = new Stage();
    public static int sandwichCount = 0;
    public static Label countSandwiches = new Label("Sandwich count: " + sandwichCount);

    OrderHeader orderHeader;
    OrderSandwichesAndToppings orderSandwichesAndToppings;
    OrderDetails orderDetails;
    OrderFooter orderFooter;

    public OrderView(OrderViewController orderViewController) {
        orderHeader = new OrderHeader(orderViewController);
        orderSandwichesAndToppings = new OrderSandwichesAndToppings(orderViewController);
        orderDetails = new OrderDetails(orderViewController);
        orderFooter = new OrderFooter(orderViewController);


        stage.setTitle("ORDER VIEW");
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(150);
        stage.setY(20);
        Group root = new Group();
        Scene scene = new Scene(root, 720, 650);

        vBox.setBackground(new Background(new BackgroundFill(Color.SNOW,new CornerRadii(0),new Insets(0))));
        countSandwiches.setFont(Font.font("Verdana", 15));
        countSandwiches.setPadding(new Insets(5, 0, 5, 10));
        vBox.getChildren().addAll(orderHeader, orderSandwichesAndToppings, countSandwiches, orderDetails, orderFooter);
        vBox.prefHeightProperty().bind(scene.heightProperty());
        vBox.prefWidthProperty().bind(scene.widthProperty());
        root.getChildren().add(vBox);


        changeallbuttons(vBox, true);

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        orderViewController.setView(this); //observer
    }

    public void updateOrderLines(List<OrderLine> orderLines) {
        orderDetails.fillTable(orderLines);
    }
    public void updateStatusSandwichesButtons(HashMap<String, Integer> stockListSandwiches) {
        orderSandwichesAndToppings.updateStatusSandwichButtons(stockListSandwiches);
    }
    public void updateStatusToppingButtons(HashMap<String, Integer> stockListTopings){
        orderSandwichesAndToppings.updateStatusToppingButtons(stockListTopings);
    }


    public static void changeallbuttons(Parent parent, boolean state) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof Button && !((Button) node).getText().equalsIgnoreCase("New order")){
                node.setDisable(state);
            }
            if (node instanceof Parent)
                changeallbuttons((Parent)node,state);
        }
    }

    public static void updatelabel(){
        sandwichCount++;
        countSandwiches.setText("Sandwich count: " + sandwichCount);
    }
    public static void resetlabel(){
        sandwichCount = 0;
        countSandwiches.setText("Sandwich count: " + sandwichCount);
    }


}
