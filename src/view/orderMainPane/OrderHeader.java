package view.orderMainPane;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.awt.*;
import java.util.Collection;

public class OrderHeader extends HBox {
    public OrderHeader() {
        Button button = new Button("New order");
        button.setEnabled(false);
        Label label = new Label("volgnr:");
        ComboBox comboBox = new ComboBox();
    }
}
