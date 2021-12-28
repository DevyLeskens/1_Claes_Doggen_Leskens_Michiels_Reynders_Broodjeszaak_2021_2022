package model;

import model.discountStrategies.*;
import model.domain.DomainException;
import model.domain.Sandwich;
import model.domain.Topping;
import model.states.*;

import java.util.ArrayList;
import java.util.List;

public class Order{

    private DiscountStrategy discountStrategy = new DiscountTenPercent();
    private OrderState orderState;
    private ArrayList<OrderLine> orderLines;
    private int follownr;

    private StateInWait stateInWait = new StateInWait(this);
    private StateInOrder stateInOrder = new StateInOrder(this);
    private StateIsTerminated stateIsTerminated = new StateIsTerminated(this);
    private StateIsPayed stateIsPayed = new StateIsPayed(this);
    private StateInWaitingLine stateInWaitingLine = new StateInWaitingLine(this);
    private StateInPreparation stateInPreparation = new StateInPreparation(this);
    private StateIsPrepared stateIsPrepared = new StateIsPrepared(this);
    private StateIsCanceled stateIsCanceled = new StateIsCanceled(this);

    public Order()  {
        orderLines = new ArrayList<>();
        setOrderState(stateInWait);
        this.follownr = OrderFacade.getNextfollownrAndIncrease();
    }
    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
    public void deleteSandwich(int id){
        orderState.deleteSandwich();
        orderLines.remove(id);

    }
    public void addIdenticalSandwich(int id){
        orderState.addIdenticalSandwich();
        orderLines.add(orderLines.get(id));
    }
    public void addOrderLine(Sandwich sandwich) {
        orderState.addSandwich();
        this.orderLines.add(new OrderLine(sandwich));
    }
    public void addTopping(int sandwichid, Topping topping) {
        orderState.addTopping();
        orderLines.get(sandwichid).addTopping(topping);
    }
    public void toKitchen() {
        orderState.sendToKitchen();
    }



    @Override
    public String toString() {
        return "Order{" +
                "orderLines=" + orderLines +
                '}';
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
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

    public StateIsCanceled getStateIsCanceled() {
        return stateIsCanceled;
    }

    public void reset(){
        orderState.cancelOrder();
        this.orderLines = new ArrayList<>();
    }
    public double getTotalPrice(){
        double total = 0;
        for (OrderLine orderline:orderLines) {
           total += orderline.getPrice();
        }
        return total;
    }
    public double getTotalPriceWithDiscount(DiscountStrategyEnum discount){
        setDiscountStrategy(DiscountFactory.createLoadSaveStrategy(discount.getLocation()));
        return getTotalPrice() - discountStrategy.calcDiscount(this);
    }
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    public double getCheapestOrderline(){
        double cheapest = orderLines.get(0).getPrice();
        for (OrderLine orderLine:orderLines){
            if(orderLine.getPrice() < cheapest){
                cheapest=orderLine.getPrice();
            }
        }
        return cheapest;
    }
    public void pay() {
        orderState.pay();
    }

    public void endOrder() {
        orderState.terminate();
    }

    public void startPreparation() {
        orderState.startPreparation();
    }

    public void orderIsDone() {
        orderState.done();
    }
}
