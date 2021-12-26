package view.orderMainPane;

import controller.OrderViewController;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.OrderLine;
import view.adminPane.AdminMainPane;
import view.orderMainPane.DetailsListAndButton.OrderDetails;

import java.util.HashMap;
import java.util.List;

public class OrderView {
    private Stage stage = new Stage();
    Label countSandwiches = new Label("Sandwich count:");
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
        VBox vBox = new VBox();
        vBox.setBackground(new Background(new BackgroundFill(Color.SNOW,new CornerRadii(0),new Insets(0))));
        countSandwiches.setFont(Font.font("Verdana", 15));
        countSandwiches.setPadding(new Insets(5, 0, 5, 10));
        vBox.getChildren().addAll(orderHeader, orderSandwichesAndToppings, countSandwiches, orderDetails, orderFooter);
        vBox.prefHeightProperty().bind(scene.heightProperty());
        vBox.prefWidthProperty().bind(scene.widthProperty());
        root.getChildren().add(vBox);
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
}
