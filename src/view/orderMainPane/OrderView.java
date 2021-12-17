package view.orderMainPane;

import controller.OrderViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
        stage.setX(20);
        stage.setY(20);
        Group root = new Group();
        Scene scene = new Scene(root, 650, 650);
        VBox vBox = new VBox();
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
