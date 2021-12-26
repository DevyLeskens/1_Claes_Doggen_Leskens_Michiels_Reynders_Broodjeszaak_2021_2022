package controller;

import model.Order;
import model.OrderEvent;
import model.OrderFacade;
import model.OrderLine;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import view.adminPane.AdminView;
import view.orderMainPane.OrderView;

import java.util.HashMap;
import java.util.List;

public class OrderViewController implements Observer {

    private OrderView orderView;
    private final OrderFacade orderFacade = OrderFacade.getInstance();


    public OrderViewController(OrderFacade orderFacade) {
        orderFacade.registerObserver(OrderEvent.ADD_SANDWICH, this);
    }

    public void setView(OrderView view) {
        this.orderView = view;
    }


    public OrderFacade getOrderFacade() {
        return orderFacade;
    }

    public void addOrderLine(String sandwichName) {
        orderFacade.addOrderline(sandwichName);
        updateOrderLines();
        updateStatusSandwichesButtons();
    }

    public void addTopping(int id, String toppingName){
        updateOrderLines();
        orderFacade.addTopping(id, toppingName);
        updateOrderLines();
    }

    public List<OrderLine> getOrderLines() {
        return orderFacade.getOrderLines();
    }

    public void updateOrderLines() {
        orderView.updateOrderLines(getOrderLines());
    }

    public HashMap<String, Integer> getStockListSandwiches() {
        return orderFacade.getStockListSandwiches();
    }

    public void updateStatusSandwichesButtons() {
        orderView.updateStatusSandwichesButtons(getStockListSandwiches());
    }

    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order) {
        System.out.println("NotifyObserversReport:\n----------------------\n - " + order.toString() + "\n - " +
                sandwichDatabase.toString() + "\n - " + toppingDatabase.toString() + "\n");
    }
}


