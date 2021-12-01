package view.panels;


import com.sun.deploy.util.StringUtils;
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

import java.util.List;
import java.util.Locale;


public class SandwichOverviewPane extends GridPane{
	//private TableView<Speler> table;
    private final TableView<Sandwich> sandwichTableView;
    private final OrderFacade orderFacade;
	private ObservableList<Sandwich> sandwiches;

	public SandwichOverviewPane() {

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        Label label = new Label("Sandwiches:");
        label.setFont(new Font(20));
		this.add(label, 0, 0, 1, 1);

		sandwichTableView = new TableView<>();
		orderFacade = new OrderFacade();
		refresh();
		String[] names = {"name", "price", "stock"};
	    this.setEqualColumns(names, sandwichTableView);
	    sandwichTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		this.add(sandwichTableView,0,1,1,1);
		System.out.println(sandwichTableView.getColumns());
	}

	public void setEqualColumns(String[] names, TableView<Sandwich> tableview){
		for (String name: names){
			TableColumn col = new TableColumn<>(name.substring(0,1).toUpperCase(Locale.ROOT) + name.substring(1).toLowerCase(Locale.ROOT));
			col.setMinWidth(50);
			col.setCellValueFactory(new PropertyValueFactory<>(name));
		    tableview.getColumns().add(col);
		}

	}
	public void refresh(){
		sandwiches = FXCollections.observableArrayList(orderFacade.getSandwichDatabase().getSandwichsorts().values());
		sandwichTableView.setItems(sandwiches);
		sandwichTableView.refresh();
	}
}
