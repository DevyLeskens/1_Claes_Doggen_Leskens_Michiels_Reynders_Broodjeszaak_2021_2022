package view.adminPane;


import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.OrderFacade;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(OrderFacade orderFacade){
	    TabPane tabPane = new TabPane();
        //Tab spelVerloopTab = new Tab("Spelverloop");
        HBox panes = new HBox();
        panes.getChildren().add(new SandwichOverviewPane(orderFacade.getSandwichDatabase().getSandwichsorts().values()));
        panes.getChildren().add(new ToppingOverviewPane(orderFacade.getToppingDatabase().getToppingsorts().values()));
        VBox stats = new VBox();
        stats.getChildren().add(new Statistics());
        Tab broodjesTab = new Tab("Broodjes/Beleg",panes);
        Tab instellingTab = new Tab("Instellingen");
        Tab statistiekTab = new Tab("Statistieken", stats);
        //tabPane.getTabs().add(spelVerloopTab);

        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}
