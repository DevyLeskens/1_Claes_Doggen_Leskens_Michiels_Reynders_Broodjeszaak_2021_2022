package controller;

import model.Order;
import model.OrderEvent;
import model.OrderFacade;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import view.KitchenPane.KitchenView;

import java.util.HashMap;
import java.util.Set;

public class KitchenViewController implements Observer {

    OrderFacade orderFacade = OrderFacade.getInstance();
    KitchenView kitchenView = new KitchenView(this);

    public KitchenViewController() {
        orderFacade.registerObserver(OrderEvent.ORDER_TO_KITCHEN, this);
    }

    public void decreaseOrderCount() {
        orderFacade.decreaseOrderCount();
    }
    public int getOrderCount(){
        return orderFacade.getOrderCount();
    }

    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int orderCount, HashMap<String , HashMap<String , Integer>> orderdone){
        System.out.println(toppingDatabase.toString() + " " + sandwichDatabase.toString() + " " + order.toString());
        kitchenView.update(orderCount);
    }
}
