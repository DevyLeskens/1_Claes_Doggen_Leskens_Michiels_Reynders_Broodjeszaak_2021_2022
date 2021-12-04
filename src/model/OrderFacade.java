package model;

import model.database.SandwichDatabase;
import model.database.ToppingDatabase;

import java.util.ArrayList;
import java.util.Observer;

public class OrderFacade implements Subject{

    private static OrderFacade orderFacade;
    private final ToppingDatabase toppingDatabase;
    private final SandwichDatabase sandwichDatabase;
    private final ArrayList<Observer> observers = new ArrayList<>();

    private OrderFacade() {
        this.toppingDatabase = new ToppingDatabase();
        this.sandwichDatabase = new SandwichDatabase();
    }
    public static OrderFacade getInstance(){
        if (orderFacade == null) {
            orderFacade = new OrderFacade();
        }
        return orderFacade;
    }

    public ToppingDatabase getToppingDatabase() { return toppingDatabase; }
    public SandwichDatabase getSandwichDatabase() {
        return sandwichDatabase;
    }


}
