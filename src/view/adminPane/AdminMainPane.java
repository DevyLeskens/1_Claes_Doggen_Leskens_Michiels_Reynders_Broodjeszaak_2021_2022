package view.adminPane;


import controller.AdminViewController;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;

public class AdminMainPane extends BorderPane {
    public AdminMainPane(AdminViewController adminViewController) {
        TabPane tabPane = new TabPane();
        //Tab spelVerloopTab = new Tab("Spelverloop");
        HBox panes = new HBox();
        panes.getChildren().add(new SandwichOverviewPane(adminViewController));
        panes.getChildren().add(new ToppingOverviewPane(adminViewController));
        VBox stats = new VBox();


        stats.getChildren().add(new Statistics(adminViewController));
        VBox settings = new VBox();
        settings.getChildren().add(new Settings(adminViewController));

        Tab broodjesTab = new Tab("Sandwiches/Toppings",panes);
        Tab instellingTab = new Tab("Settings", settings);
        Tab statistiekTab = new Tab("Statistics", stats);
        //tabPane.getTabs().add(spelVerloopTab);

        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
    }
}
