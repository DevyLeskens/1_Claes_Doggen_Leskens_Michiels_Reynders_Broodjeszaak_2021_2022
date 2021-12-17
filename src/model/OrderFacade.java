package model;

import model.database.SandwichDatabase;
import model.database.ToppingDatabase;

import java.util.*;

public class OrderFacade implements Subject{
    private static OrderFacade orderFacade;
    private final ToppingDatabase toppingDatabase;
    private final SandwichDatabase sandwichDatabase;
    private Order order;
    private final Map<OrderEvent, List<Observer>> observers = new HashMap<>();


    private OrderFacade() {
        this.toppingDatabase = ToppingDatabase.getInstance();
        this.sandwichDatabase = SandwichDatabase.getInstance();

        for (OrderEvent orderEvent: OrderEvent.values()) {
            observers.put(orderEvent, new ArrayList<Observer>());
        }
    }
    /* ----------- singleton-------------*/
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
    public void registerObserver(OrderEvent orderEvent, Observer observer) {
        observers.get(orderEvent).add(observer);
    }

    @Override
    public void removeObserver(OrderEvent orderEvent, Observer o) {
        observers.get(orderEvent).(observer);
    }

    @Override
    public void notifyObservers(int count) {

    }
}
