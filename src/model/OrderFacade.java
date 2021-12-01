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
        this.toppingDatabase = ToppingDatabase.getInstance();
        this.sandwichDatabase = SandwichDatabase.getInstance();
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

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer:observers) {
            observer.notify();
        }
    }
}
