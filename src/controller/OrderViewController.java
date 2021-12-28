package controller;

import model.*;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import model.discountStrategies.DiscountStrategyEnum;
import model.states.OrderStateException;
import view.orderMainPane.OrderView;

import java.util.ArrayList;
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
    public void errorBox(String infoMessage) {orderView.errorBox(infoMessage,"Action not permitted");}

    public void addOrderLine(String sandwichName) {
        try{
            orderFacade.addOrderline(sandwichName);
            updateOrderLines();
            updateStatusSandwichesButtons();
        }
        catch (OrderStateException e){
            errorBox("You can not add this order.");
        }
    }

    public void toKitchen(){
        orderFacade.toKitchen();
        updateOrderLines();
    }
    public void addTopping(int id, String toppingName){
        try {
            orderFacade.addTopping(id, toppingName);
            updateOrderLines();
            updateStatusToppingButtons();
        }
        catch (OrderStateException e){
            errorBox("You first have to add a sandwich.");
        }

    }
    public void calculateDiscount(DiscountStrategyEnum discount){
        orderView.updateOrderLines(getOrderLines() , orderFacade.getDiscountAmount(discount));
    }
    public ArrayList<String> getDiscounts(){
        return orderFacade.getDiscounts();
    }
    public List<OrderLine> getOrderLines() {
        return orderFacade.getOrderLines();
    }

    public void updateOrderLines() {
        orderView.updateOrderLines(getOrderLines() , orderFacade.getAmount());
    }

    public void cancelOrder(){
        try{
            orderFacade.cancelOrder();
            updateOrderLines();
        }
        catch (OrderStateException e){
            errorBox("Kan deze order niet annuleren");
        }

    }
    public void updateStatusSandwichesButtons() {
        orderView.updateStatusSandwichesButtons(orderFacade.getStockListSandwiches());
    }
    public void updateStatusToppingButtons(){
        orderView.updateStatusToppingButtons(orderFacade.getStockListToppings());
    }


    public String getPreferredDiscountStrategy(){
        return Settings.getPreferredDiscountStrategySettings();
    }
    public void addIdenticalSandwich(int id) {
        try{
            orderFacade.addIdenticalSandwich(id);
            updateOrderLines();
        }catch (OrderStateException e){
            errorBox("Kan identieke broodje niet toevoegen");
        }

    }
    public int getfollownr() {
       return orderFacade.getfollownr();
    }
    public void deleteSandwich(int id){
        try{
            orderFacade.deleteSandwich(id);
            updateOrderLines();
        }catch (OrderStateException e){
            errorBox("Kan broodje niet verwijderen");
        }

    }
    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int ordercount, boolean orderisinspected, HashMap<String, HashMap<String, Integer>> orderdone, HashMap<String, Integer> peek) {
        System.out.println("NotifyObserversReport:\n----------------------\n - " + order.toString() + "\n - " +
                sandwichDatabase.toString() + "\n - " + toppingDatabase.toString() + "\n");
    }

    public void pay() {
        orderFacade.pay();
    }

    public void endOrder(DiscountStrategyEnum selectedItem) {
        calculateDiscount(selectedItem);
        orderFacade.endOrder();
    }
}


