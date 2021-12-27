package view.adminPane;

import controller.AdminViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.database.ExcelLoadSaveTemplate;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.discountStrategies.DiscountStrategyEnum;
import view.orderMainPane.OrderHeader;

import java.util.List;

public class Settings extends VBox {
    AdminViewController adminViewController;
    Label select = new Label("Select here which type of file structure");
    Label discount = new Label("Select which item you want to see first");
    ChoiceBox<String> fileStructure = new ChoiceBox<>(FXCollections.observableArrayList( "excel","Text"));
    Button saveButton = new Button("save");



    ChoiceBox itemFirst = new ChoiceBox();
    public Settings(AdminViewController adminViewController){
        DiscountStrategyEnum[] discounts = adminViewController.getAllDiscounts();
        for (DiscountStrategyEnum discount: discounts) {
            itemFirst.getItems().add(discount);
        }
        itemFirst.setValue(discounts[0]);

        saveButton.setOnAction(event -> {
            adminViewController.savePreferences((DiscountStrategyEnum) itemFirst.getSelectionModel().getSelectedItem(), fileStructure.getSelectionModel().getSelectedItem());

        });
        fileStructure.setValue("excel");
        //panes
        BorderPane fileReading = new BorderPane();
        fileReading.setLeft(select);
        fileReading.setRight(fileStructure);
        fileReading.setPadding(new Insets(10,40,50,20));
        BorderPane discountSelect = new BorderPane();
        discountSelect.setLeft(discount);
        discountSelect.setRight(itemFirst);
        discountSelect.setPadding(new Insets(0,10,207,20));
        BorderPane savebutton = new BorderPane();
        savebutton.setCenter(saveButton);
        savebutton.setPadding(new Insets(10,10,5,10));
        saveButton.setFont(Font.font("Verdana", 20));
        saveButton.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, new CornerRadii(5), new Insets(0))));
        savebutton.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        saveButton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));

        //css
        select.setFont(Font.font("Verdana", 20));
        discount.setFont(Font.font("Verdana", 20));
        //add all to root
        this.getChildren().addAll( fileReading , discountSelect, savebutton);

    }
}
