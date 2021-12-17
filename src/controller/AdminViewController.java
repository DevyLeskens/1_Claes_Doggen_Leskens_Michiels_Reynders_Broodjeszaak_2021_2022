package controller;

import model.Order;
import model.OrderEvent;
import model.OrderFacade;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import view.adminPane.AdminView;


public class AdminViewController implements Observer {

    private AdminView adminView;
    private final OrderFacade orderFacade = OrderFacade.getInstance();

    public AdminViewController(OrderFacade orderFacade) {
        orderFacade.registerObserver(OrderEvent.ADD_SANDWICH, this);
    }

    public void setView(AdminView view) {
        this.adminView = view;
    }


    public OrderFacade getOrderFacade() {
        return orderFacade;
    }

    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order) {
        System.out.println(toppingDatabase.toString() + " " + sandwichDatabase.toString() + " " + order.toString());
    }
}
