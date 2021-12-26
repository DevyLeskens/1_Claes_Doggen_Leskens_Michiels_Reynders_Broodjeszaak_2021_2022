package view.orderMainPane.DetailsListAndButton;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class CancelButton extends BorderPane {
    Button cancelOrder = new Button("cancel order");

    public CancelButton(){
        cancelOrder.setFont(Font.font("Verdana",15));
        this.setCenter(cancelOrder);
    }
}
