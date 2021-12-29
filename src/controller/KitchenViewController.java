package controller;

import model.Order;
import model.OrderEvent;
import model.OrderFacade;
import model.OrderLine;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import view.KitchenPane.KitchenView;

import java.util.HashMap;

public class KitchenViewController implements Observer {

    OrderFacade orderFacade;
    KitchenView kitchenView;

    public KitchenViewController(OrderFacade orderfacade) {
        this.orderFacade = orderfacade;
        orderFacade.registerObserver(OrderEvent.START_PREPARATION, this);
        orderFacade.registerObserver(OrderEvent.ORDER_TO_KITCHEN, this);
        orderFacade.registerObserver(OrderEvent.ORDER_IS_DONE, this);
    }

    // TODO getter voor ordernumber
    public int getOrderCount() {
        return orderFacade.getOrderCount();
    }

    public void setKitchenView(KitchenView kitchenView) {
        this.kitchenView = kitchenView;
    }

    public void startPreparation() {
        orderFacade.startPreparation();
    }

    public void Done() {
        orderFacade.Done();
    }

    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int orderCount, boolean orderIsInspected, HashMap<OrderLine, Integer> peek, int followNr) {
        System.out.println(toppingDatabase.toString() + " " + sandwichDatabase.toString() + " " + order.toString());
        kitchenView.update(followNr, orderCount, orderIsInspected, peek, this);
    }

}
