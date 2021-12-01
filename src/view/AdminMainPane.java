package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.OrderFacade;
import view.panels.SandwichOverviewPane;
import view.panels.ToppingOverviewPane;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(){
	    TabPane tabPane = new TabPane();
        //Tab spelVerloopTab = new Tab("Spelverloop");
        HBox panes = new HBox();
        OrderFacade orderFacade = new OrderFacade();
        panes.getChildren().add(new SandwichOverviewPane(orderFacade.getSandwichDatabase().getSandwichsorts().values()));
        panes.getChildren().add(new ToppingOverviewPane(orderFacade.getToppingDatabase().getToppingsorts().values()));
        Tab broodjesTab = new Tab("Broodjes/Beleg",panes);
        Tab instellingTab = new Tab("Instellingen");
        Tab statistiekTab = new Tab("Statistieken");
        //tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}
