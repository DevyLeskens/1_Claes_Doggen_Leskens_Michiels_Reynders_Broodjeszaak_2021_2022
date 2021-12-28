package controller;

import model.Order;
import model.OrderEvent;
import model.OrderFacade;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import view.KitchenPane.KitchenView;

import java.util.HashMap;

public class KitchenViewController implements Observer {

    OrderFacade orderFacade = OrderFacade.getInstance();
    KitchenView kitchenView = new KitchenView(this);

    public KitchenViewController() {
        orderFacade.registerObserver(OrderEvent.START_PREPARATION, this);
        orderFacade.registerObserver(OrderEvent.ORDER_TO_KITCHEN, this);
        orderFacade.registerObserver(OrderEvent.ORDER_IS_DONE, this);

    }


    public int getOrderCount(){
        return orderFacade.getOrderCount();
    }

    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int orderCount, boolean orderisinspected, HashMap<String, HashMap<String, Integer>> ordersdone, HashMap<String, Integer> peek){
        System.out.println(toppingDatabase.toString() + " " + sandwichDatabase.toString() + " " + order.toString());
        kitchenView.update(orderCount, orderisinspected,peek);
    }

    public void startPreparation() {
        orderFacade.startPreparation();
    }

    public void Done() {
        orderFacade.Done();
    }
}
