package view.adminPane;


import model.domain.Topping;
import java.util.Collection;



public class ToppingOverviewPane extends OverviewPane<Topping>{
	public ToppingOverviewPane(Collection<Topping> values) {
		super("Topping", values, new String[]{"name", "price", "stock"});
	}
}
