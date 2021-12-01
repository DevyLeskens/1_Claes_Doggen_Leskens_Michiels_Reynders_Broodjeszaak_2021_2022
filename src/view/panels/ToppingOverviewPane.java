package view.panels;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import model.OrderFacade;
import model.domain.Sandwich;
import model.domain.Topping;

import java.util.Locale;


public class ToppingOverviewPane extends GridPane{
	//private TableView<Speler> table;

	private final TableView<Topping> toppingTableView;
    private final OrderFacade orderFacade;
	private ObservableList<Topping> toppings;

	public ToppingOverviewPane() {

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
		Label label = new Label("Toppings:");
		label.setFont(new Font(20));
		this.add(label, 0, 0, 1, 1);

		toppingTableView = new TableView<>();
		orderFacade = new OrderFacade();
		refresh();
		String[] names = {"name", "price", "stock"};
		toppingTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		this.setEqualColumns(names, toppingTableView);
		this.add(toppingTableView,0,1,1,1);

	}
	public void setEqualColumns(String[] names, TableView<Topping> tableview){
		for (String name: names) {
			TableColumn col = new TableColumn<>(name.substring(0,1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT));
			col.setMinWidth(50);
			col.setCellValueFactory(new PropertyValueFactory<>(name));
		    tableview.getColumns().add(col);
		}
	}
	public void refresh(){
		toppings = FXCollections.observableArrayList(orderFacade.getToppingDatabase().getToppingsorts().values());
		toppingTableView.setItems(toppings);
		toppingTableView.refresh();
	}
}
