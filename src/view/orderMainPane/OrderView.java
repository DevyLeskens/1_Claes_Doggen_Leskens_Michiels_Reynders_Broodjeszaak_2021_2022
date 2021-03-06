package view.orderMainPane;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.OrderLine;
import view.orderMainPane.DetailsListAndButton.OrderDetails;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OrderView {

    public int orderCount;
    public static VBox vBox = new VBox();
    private Stage stage = new Stage();
    public static Label countSandwiches = new Label("Sandwich count: /");

    OrderHeader orderHeader;
    OrderSandwichesAndToppings orderSandwichesAndToppings;
    OrderDetails orderDetails;
    OrderFooter orderFooter;
    OrderViewController orderViewController;

    public OrderView(OrderViewController orderViewController) {
        this.orderViewController = orderViewController;
        //go to lower functions
        orderHeader = new OrderHeader(orderViewController);
        orderSandwichesAndToppings = new OrderSandwichesAndToppings(orderViewController);
        orderDetails = new OrderDetails(orderViewController);
        orderFooter = new OrderFooter(orderViewController);

        //stage & group
        stage.setTitle("ORDER VIEW");
        stage.initStyle(StageStyle.UTILITY);
        stage.setX(150);
        stage.setY(20);
        Group root = new Group();
        Scene scene = new Scene(root, 720, 650);

        //css
        vBox.setBackground(new Background(new BackgroundFill(Color.SNOW, new CornerRadii(0), new Insets(0))));
        countSandwiches.setFont(Font.font("Verdana", 15));
        countSandwiches.setPadding(new Insets(5, 0, 5, 10));
        vBox.getChildren().addAll(orderHeader, orderSandwichesAndToppings, countSandwiches, orderDetails, orderFooter);
        vBox.prefHeightProperty().bind(scene.heightProperty());
        vBox.prefWidthProperty().bind(scene.widthProperty());

        //Add to root
        root.getChildren().add(vBox);

        //button new order
        ArrayList<String> dontChange = new ArrayList<>(Arrays.asList("New order"));
        changeAllButtons(vBox, true, dontChange);

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

        //set view ---OBSERVER---
        orderViewController.setView(this);
    }

    public void increaseOrderCount() {
        orderCount++;
    }

    public int getOrderCount() {
        return orderCount;
    }

    public void decreaseOrderCount() {
        orderCount--;
    }


    public static void changeAllButtons(Parent parent, boolean state, ArrayList<String> dontChange) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            if (node instanceof Button) {
                node.setDisable(state);
            }
            if (node instanceof Button && dontChange.contains(((Button) node).getText())) {
                node.setDisable(!state);
            }
            if (node instanceof Parent)
                changeAllButtons((Parent) node, state, dontChange);
        }
    }


    public static void resetLabel() {
        countSandwiches.setText("Sandwich count: 0");
    }

    public void errorBox(String infoMessage) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Action not permitted");
        errorAlert.setContentText(infoMessage);
        errorAlert.showAndWait();
    }

    public void update(List<OrderLine> orderLines, double amount){
        countSandwiches.setText("Sandwich count: " + orderViewController.getSandwichCount());
        orderDetails.fillTable(orderLines);
        OrderFooter.updateAmount(amount);
        updatebuttons(orderViewController);
    }
    public static void updatebuttons(OrderViewController orderViewController){
        OrderSandwichesAndToppings.updateStatusToppingButtons(orderViewController.getOrderFacade().getStockListToppings());
        OrderSandwichesAndToppings.updateStatusSandwichButtons(orderViewController.getOrderFacade().getStockListSandwiches());
    }
}
