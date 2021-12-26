package view.orderMainPane;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class FooterToKitchenAndPay extends HBox {
    Button pay = new Button("Pay");
    Button toKitchen = new Button("To kitchen");

    public FooterToKitchenAndPay(){
        this.setSpacing(30);
        pay.setFont(Font.font("Verdana", 20));
        pay.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        toKitchen.setFont(Font.font("Verdana", 20));
        toKitchen.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        this.getChildren().addAll(pay,toKitchen);
    }
}
