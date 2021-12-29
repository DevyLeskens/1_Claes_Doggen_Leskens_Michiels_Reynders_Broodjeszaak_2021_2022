package model;

import model.discountStrategies.*;
import model.domain.DomainException;
import model.domain.Sandwich;
import model.domain.Topping;
import model.states.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Order {

    private OrderState orderState;
    private ArrayList<OrderLine> orderLines;
    private int followNr = 0;

    private StateInWait stateInWait = new StateInWait(this);
    private StateInOrder stateInOrder = new StateInOrder(this);
    private StateIsTerminated stateIsTerminated = new StateIsTerminated(this);
    private StateIsPayed stateIsPayed = new StateIsPayed(this);
    private StateInWaitingLine stateInWaitingLine = new StateInWaitingLine(this);
    private StateInPreparation stateInPreparation = new StateInPreparation(this);
    private StateIsPrepared stateIsPrepared = new StateIsPrepared(this);

    public Order(int followNr) {
        orderLines = new ArrayList<>();
        setOrderState(stateInWait);
        this.followNr = followNr;
    }

    public StateInOrder getStateInOrder() {
        return stateInOrder;
    }

    public StateIsTerminated getStateIsTerminated() {
        return stateIsTerminated;
    }

    public StateInWait getStateInWait() {
        return stateInWait;
    }

    public StateIsPayed getStateIsPayed() {
        return stateIsPayed;
    }

    public StateInWaitingLine getStateInWaitingLine() {
        return stateInWaitingLine;
    }

    public StateInPreparation getStateInPreparation() {
        return stateInPreparation;
    }

    public StateIsPrepared getStateIsPrepared() {
        return stateIsPrepared;
    }


    public int getFollowNr() {
        return followNr;
    }

    public double getTotalPrice() {
        return orderLines.stream().mapToDouble(OrderLine::getPrice).sum();
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public double getTotalPriceWithDiscount(DiscountStrategyEnum discount) {
        return getTotalPrice() - discount.getStrategy().calcDiscount(this);
    }

    public double getCheapestOrderLine() {
        return orderLines.stream().mapToDouble(OrderLine::getPrice).min().orElseThrow(DomainException::new);
    }

    public HashMap<OrderLine, Integer> giveOrderAsHashMap() {
        HashMap<OrderLine, Integer> order = new HashMap<>();
        getOrderLines().forEach(orderLine -> order.put(orderLine, order.computeIfAbsent(orderLine, k -> 0) + 1));
        return order;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void addOrderLine(Sandwich sandwich) {
        if(sandwich.getStock() < 1){ throw new OrdelineException(sandwich.getName() + " is uit stock!");}
        orderState.addSandwich();
        this.orderLines.add(new OrderLine(sandwich));
    }

    public void deleteOrderLine(int id) {
        orderState.deleteSandwich();
        orderLines.remove(id);
    }

    public void addIdenticalSandwich(int id) {
        checkifAddisPossible(orderLines.get(id));
        orderState.addIdenticalSandwich();
        orderLines.add(orderLines.get(id));
    }

    public void addTopping(int sandwichId, Topping topping) {
        if(topping.getStock() == 0){ throw new OrdelineException(topping.getName() + " is uit stock!");}
        orderState.addTopping();
        orderLines.get(sandwichId).addTopping(topping);
    }

    public void endOrder() {
        orderState.terminate();
    }

    public void pay() {
        orderState.pay();
    }

    public void toKitchen() {
        orderState.sendToKitchen();
    }

    public void startPreparation() {
        orderState.startPreparation();
    }

    public void orderIsDone() {
        orderState.done();
    }

    public void checkifAddisPossible(OrderLine orderLine){
        if(orderLine.getSandwich().getStock() == 0){ throw new OrdelineException(orderLine.getSandwichname() + " is uit stock!");}
        for (Map.Entry<Topping, Integer> orderline: orderLine.getToppingsAsProductMap().entrySet()) {
            if(orderline.getKey().getStock() < orderline.getValue()){ throw new OrdelineException(orderline.getKey().getName() + " is uit stock!");}
        }
    }
    public void reset() {
        orderState.cancelOrder();
        this.orderLines = new ArrayList<>();
    }

    @Override
    public String toString() {
        return orderLines.toString();
    }

}
