package view.panels;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.OrderFacade;
import model.domain.Sandwich;


public class SandwichOverviewPane extends GridPane{
	//private TableView<Speler> table;
    private final TableView<Sandwich> sandwichTableView;
    private final OrderFacade orderFacade;
	private ObservableList<Sandwich> sandwiches;

	public SandwichOverviewPane() {

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
		this.add(new Label("Broodjes:"), 0, 0, 1, 1);

		sandwichTableView = new TableView<>();
		orderFacade = new OrderFacade();
		refresh();

		TableColumn<Sandwich, String> colName = new TableColumn<>("name");
		colName.setMinWidth(50);
		colName.setCellValueFactory(new PropertyValueFactory<>("name"));

		TableColumn<Sandwich,Double> colPrice = new TableColumn<>("price");
		colPrice.setMinWidth(50);
		colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

		TableColumn<Sandwich, Integer> colStock = new TableColumn<>("stock");
		colStock.setMinWidth(50);
		colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

		sandwichTableView.getColumns().addAll(colName,colPrice , colStock);

		this.getChildren().addAll(sandwichTableView);

	}


	public void refresh(){
		sandwiches = FXCollections.observableArrayList(orderFacade.getSandwichDatabase().getSandwichsorts().values());
		sandwichTableView.setItems(sandwiches);
		sandwichTableView.refresh();
	}
}
