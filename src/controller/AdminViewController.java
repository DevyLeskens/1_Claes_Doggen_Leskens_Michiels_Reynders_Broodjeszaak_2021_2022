package controller;

import model.OrderFacade;
import view.adminPane.AdminView;

import java.util.Observable;
import java.util.Observer;

public class AdminViewController implements Observer {

    private AdminView adminView;
    private final OrderFacade orderFacade = OrderFacade.getInstance();

    public AdminViewController(OrderFacade orderFacade) {
        orderFacade.registerObserver(this);
    }

    public void setView(AdminView view) {
        this.adminView = view;
    }


    public OrderFacade getOrderFacade() {
        return orderFacade;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
