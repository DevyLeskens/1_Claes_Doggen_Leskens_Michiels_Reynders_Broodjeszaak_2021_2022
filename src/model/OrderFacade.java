package model;

import model.database.SandwichDatabase;
import model.database.ToppingDatabase;

public class OrderFacade {

    private final ToppingDatabase toppingDatabase;
    private final SandwichDatabase sandwichDatabase;

    public OrderFacade() {
        this.toppingDatabase = ToppingDatabase.getInstance();
        this.sandwichDatabase = SandwichDatabase.getInstance();
    }

    public ToppingDatabase getToppingDatabase() { return toppingDatabase; }
    public SandwichDatabase getSandwichDatabase() {
        return sandwichDatabase;
    }
}
