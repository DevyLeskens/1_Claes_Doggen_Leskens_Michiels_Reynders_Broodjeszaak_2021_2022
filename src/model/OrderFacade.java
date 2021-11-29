package model;

import model.database.SandwichDatabase;

public class OrderFacade {


    private final SandwichDatabase sandwichDatabase;

    public OrderFacade() {
        this.sandwichDatabase = SandwichDatabase.getInstance();
    }

    public SandwichDatabase getSandwichDatabase() {
        return sandwichDatabase;
    }
}
