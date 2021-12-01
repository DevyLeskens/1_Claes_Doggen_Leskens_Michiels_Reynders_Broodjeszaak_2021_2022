package view;


import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import view.panels.SandwichOverviewPane;
import view.panels.ToppingOverviewPane;

public class AdminMainPane extends BorderPane {
	public AdminMainPane(){
	    TabPane tabPane = new TabPane();
        //Tab spelVerloopTab = new Tab("Spelverloop");
        HBox sandwichpanes = new HBox();
        sandwichpanes.getChildren().add(new SandwichOverviewPane());
        sandwichpanes.getChildren().add(new ToppingOverviewPane());
        Tab broodjesTab = new Tab("Broodjes/Beleg",sandwichpanes);
        Tab instellingTab = new Tab("Instellingen");
        Tab statistiekTab = new Tab("Statistieken");
        //tabPane.getTabs().add(spelVerloopTab);
        tabPane.getTabs().add(broodjesTab);
        tabPane.getTabs().add(statistiekTab);
        tabPane.getTabs().add(instellingTab);
        this.setCenter(tabPane);
	}
}
