package controller;

import model.*;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import model.discountStrategies.DiscountStrategyEnum;
import model.states.OrderStateException;
import view.orderMainPane.OrderView;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderViewController implements Observer {


    private OrderView orderView;
    private final OrderFacade orderFacade = OrderFacade.getInstance();


    public OrderViewController(OrderFacade orderFacade) {
        orderFacade.registerObserver(OrderEvent.ADD_SANDWICH, this);
        orderFacade.registerObserver(OrderEvent.Add_TOPPING, this);
        orderFacade.registerObserver(OrderEvent.ADD_IDENTICAL_SANDWICH, this);
        orderFacade.registerObserver(OrderEvent.ORDER_TO_KITCHEN, this);
        orderFacade.registerObserver(OrderEvent.CANCEL_ORDER, this);
        orderFacade.registerObserver(OrderEvent.DELETE_SANDWICH, this);

    }

    public void setView(OrderView view) {
        this.orderView = view;
    }

    public void errorBox(String infoMessage) {
        orderView.errorBox(infoMessage);
    }

    public void addOrderLine(String sandwichName) {
        try {
            orderFacade.addOrderLine(sandwichName);
        } catch (OrderStateException e) {
            errorBox("adding is prohibited");
        }catch (OrdelineException e){
            errorBox(e.getMessage());
        }
    }

    public void toKitchen() {
        try {
            orderFacade.toKitchen();
        } catch (OrderStateException e) {
            errorBox("To kitchen is prohibited atm");
        }

    }
    public void addTopping(int id, String toppingName) {
        try {
            orderFacade.addTopping(id, toppingName);
        } catch (OrderStateException e) {
            errorBox("You first have to add a sandwich.");
        }catch (OrdelineException e){
            errorBox(e.getMessage());
        }

    }
    public void cancelOrder() {
        try {
            orderFacade.cancelOrder();
        } catch (OrderStateException e) {
            errorBox("Can not cancel order");
        }

    }
    public void addIdenticalSandwich(int id) {
        try {
            orderFacade.addIdenticalSandwich(id);
        } catch (OrderStateException e) {
            errorBox("Can not add order");
        }catch (OrdelineException e){
             errorBox(e.getMessage());
        }

    }
    public void deleteSandwich(int id) {
        try {
            orderFacade.deleteSandwich(id);
        } catch (OrderStateException e) {
            errorBox("can not delete order");
        }catch (OrdelineException e){
            errorBox(e.getMessage());
        }

    }

    public void calculateDiscount(DiscountStrategyEnum discount) {
        orderView.update(getOrderLines(), orderFacade.getDiscountAmount(discount));
    }

    public int getSandwichCount(){ return orderFacade.getSandwichCount(); }

    public ArrayList<String> getDiscounts() {
        return orderFacade.getDiscounts();
    }

    public DiscountStrategyEnum[] getDiscountsEnum() {
        return orderFacade.getDiscountsEnum();
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderFacade.getOrderLines();
    }



    public void updateBase() {
        orderFacade.updateBase();
    }

    public OrderFacade getOrderFacade() {
        return orderFacade;
    }

    public String getPreferredDiscountStrategy() {
        return Settings.getPreferredDiscountStrategySettings();
    }

    public int getFollowNr() {
        return orderFacade.getFollowNr();
    }


    public void pay() {
        orderFacade.pay();
    }

    public ArrayList<String> getAllDiscounts() {
        return orderFacade.getDiscounts();
    }

    public void endOrder(DiscountStrategyEnum selectedItem) {
        calculateDiscount(selectedItem);
        orderFacade.endOrder();
    }
    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int orderCount, boolean orderIsInspected, HashMap<OrderLine, Integer> peek, int followNr) {
        System.out.println("NotifyObserversReport:\n----------------------\n - " + order.toString() + "\n - " +
                sandwichDatabase.toString() + "\n - " + toppingDatabase.toString() + "\n");

        orderView.update(getOrderLines(), orderFacade.getAmount());
    }


}


