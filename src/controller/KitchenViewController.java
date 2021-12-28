package controller;

import model.Order;
import model.OrderEvent;
import model.OrderFacade;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import view.KitchenPane.KitchenView;

import java.util.HashMap;

public class KitchenViewController implements Observer {

    OrderFacade orderFacade;
    KitchenView kitchenView;

    public KitchenViewController(OrderFacade orderfacade) {
        this.orderFacade=orderfacade;
        orderFacade.registerObserver(OrderEvent.START_PREPARATION, this);
        orderFacade.registerObserver(OrderEvent.ORDER_TO_KITCHEN, this);
        orderFacade.registerObserver(OrderEvent.ORDER_IS_DONE, this);

    }

    public void setKitchenView(KitchenView kitchenView) {
        this.kitchenView = kitchenView;
    }

    public int getOrderCount(){
        return orderFacade.getOrderCount();
    }

    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int countOrder, boolean orderIsInspected, HashMap<String, HashMap<String, Integer>> orderDone, HashMap<String, Integer> peek) {
        System.out.println(toppingDatabase.toString() + " " + sandwichDatabase.toString() + " " + order.toString());
        kitchenView.update(countOrder, orderIsInspected,peek);
    }

    public void startPreparation() {
        orderFacade.startPreparation();
    }

    public void done() {
        orderFacade.done();
    }
}
