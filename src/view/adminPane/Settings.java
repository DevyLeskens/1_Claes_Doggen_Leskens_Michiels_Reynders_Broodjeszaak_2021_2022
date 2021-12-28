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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Settings extends VBox {
    AdminViewController adminViewController;
    Label intro = new Label("In here you can change your preferences for using the app.");
    Label select = new Label("Select here which type of file structure");
    Label discount = new Label("Select which item you want to see first");
    ChoiceBox<String> fileStructure = new ChoiceBox<>(FXCollections.observableArrayList( "excel","Text"));
    Button saveButton = new Button("save");
    ChoiceBox<String> itemFirst;
    public Settings(AdminViewController adminViewController){
        itemFirst = new ChoiceBox<>(FXCollections.observableArrayList(adminViewController.getAllDiscounts()));
        System.out.println(adminViewController.getPreferredDiscountStrategy());
        itemFirst.setValue(adminViewController.getPreferredDiscountStrategy());

        saveButton.setOnAction(event -> {
            adminViewController.savePreferences(fileStructure.getSelectionModel().getSelectedItem(), itemFirst.getSelectionModel().getSelectedItem().toString());
        });
        fileStructure.setValue(adminViewController.getProductFormatReader());
        //panes
        BorderPane introw = new BorderPane();
        introw.setCenter(intro);
        introw.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        intro.setFont(Font.font("Verdana", 15));
        introw.setPadding(new Insets(10,10,10,10));
        BorderPane fileReading = new BorderPane();
        fileReading.setLeft(select);
        fileReading.setRight(fileStructure);
        fileReading.setPadding(new Insets(10,40,50,20));
        BorderPane discountSelect = new BorderPane();
        discountSelect.setLeft(discount);
        discountSelect.setRight(itemFirst);
        discountSelect.setPadding(new Insets(0,10,168,20));
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
        this.getChildren().addAll( introw, fileReading , discountSelect, savebutton);

    }
}
