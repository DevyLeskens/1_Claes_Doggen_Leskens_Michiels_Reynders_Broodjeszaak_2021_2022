package controller;

import model.OrderEvent;
import model.OrderFacade;
import view.adminPane.AdminView;
import view.orderMainPane.OrderView;

import java.util.Observable;
import java.util.Observer;

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

    @Override
    public void update(Observable o, Object arg) {

    }

}


