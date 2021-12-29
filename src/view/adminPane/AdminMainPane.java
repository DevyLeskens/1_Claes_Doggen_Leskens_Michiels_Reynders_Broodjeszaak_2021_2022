package view.adminPane;


import controller.AdminViewController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AdminMainPane extends BorderPane {
    public AdminMainPane(AdminViewController adminViewController) {
        Label footerText = new Label("In here, you can see the current stock/price of our products.");
        TabPane tabPane = new TabPane();
        //sandwiches and topping page

        //create header and tables
        VBox headerAndPane = new VBox();
        HBox panes = new HBox();
        panes.getChildren().add(new SandwichOverviewPane(adminViewController));
        panes.getChildren().add(new ToppingOverviewPane(adminViewController));
        Tab broodjesTab = new Tab("Sandwiches/Toppings",headerAndPane);
        tabPane.getTabs().add(broodjesTab);

        //header
        BorderPane header = new BorderPane();
        Label sandwiches = new Label("Sandwiches");
        Label toppings = new Label("Toppings");
        sandwiches.setFont(Font.font("Verdana", 20));
        toppings.setFont(Font.font("Verdana", 20));
        header.setLeft(sandwiches);
        header.setRight(toppings);
        sandwiches.setPadding(new Insets(5,0,10,0));
        toppings.setPadding(new Insets(5,0,10,0));
        header.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        header.setPadding(new Insets(0, 110, 0, 95));

        //footer
        BorderPane footer = new BorderPane();
        footer.setBackground(new Background(new BackgroundFill(Color.DARKSEAGREEN, new CornerRadii(0), new Insets(0))));
        footer.setMinHeight(30);
        footer.setCenter(footerText);
        footerText.setFont(Font.font("Verdana",15));

        //Stat page
        VBox stats = new VBox();
        stats.getChildren().add(new Statistics(adminViewController));
        Tab statistiekTab = new Tab("Statistics", stats);
        tabPane.getTabs().add(statistiekTab);

        //setting page
        VBox settings = new VBox();
        settings.getChildren().add(new Settings(adminViewController));
        Tab instellingTab = new Tab("Settings", settings);
        tabPane.getTabs().add(instellingTab);

        // add to root
        this.setCenter(tabPane);
        headerAndPane.getChildren().addAll(header, panes, footer);
    }
}
