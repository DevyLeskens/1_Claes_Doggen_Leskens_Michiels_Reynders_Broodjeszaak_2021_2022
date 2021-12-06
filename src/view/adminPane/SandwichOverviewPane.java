package view.adminPane;

import model.domain.Sandwich;
import java.util.Collection;

public class SandwichOverviewPane extends OverviewPane<Sandwich>{
	public SandwichOverviewPane (Collection<Sandwich> values) {
		super("Sandwich", values, new String[]{"name", "price", "stock"});
	}
}
