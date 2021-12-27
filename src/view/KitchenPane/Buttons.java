package view.KitchenPane;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Buttons extends BorderPane {
    Button next = new Button("Next order");
    Button orderFinished = new Button("Order finished");

    public Buttons(){
        this.setLeft(next);
        this.setRight(orderFinished);
        this.setPadding(new Insets(5,10,5,10));
        this.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(5), new Insets(0))));
        next.setFont(Font.font("Verdana",20));
        orderFinished.setFont(Font.font("Verdana",20));
        next.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        orderFinished.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        next.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5), new Insets(0))));
        orderFinished.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5), new Insets(0))));


    }
}
