package model;

import model.domain.Sandwich;
import model.states.*;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private OrderState orderState;
    private ArrayList<OrderLine> orderLines;

    private StateInWait stateInWait = new StateInWait(this);
    private StateInOrder stateInOrder = new StateInOrder(this);
    private StateIsTerminated stateIsTerminated = new StateIsTerminated(this);
    private StateIsPayed stateIsPayed = new StateIsPayed(this);
    private StateInWaitingLine stateInWaitingLine = new StateInWaitingLine(this);
    private StateInPreparation stateInPreparation = new StateInPreparation(this);
    private StateIsPrepared stateIsPrepared = new StateIsPrepared(this);
    private StateIsCanceled stateIsCanceled = new StateIsCanceled(this);

    public Order() {
        orderLines = new ArrayList<>();
        setOrderState(new StateInOrder(this));
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void addOrderLine(Sandwich sandwich) {
        orderState.addSandwich();
        this.orderLines.add(new OrderLine(sandwich));
    }
    public void addTopping(int sandwichid, String toppingname) {
        orderState.addTopping();
        orderLines.get(sandwichid).addTopping(toppingname);
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
}
