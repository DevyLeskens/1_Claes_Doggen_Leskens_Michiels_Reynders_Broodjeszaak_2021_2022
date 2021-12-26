package model;

import model.database.SandwichDatabase;
import model.domain.Sandwich;
import model.states.OrderState;
import model.states.StateInOrder;
import model.states.StateIsTerminated;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private OrderState orderState;
    private ArrayList<OrderLine> orderLines;

    private StateInOrder stateInOrder = new StateInOrder(this);
    private StateIsTerminated stateIsTerminated = new StateIsTerminated(this);

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
        orderState.addSanchwich();
        this.orderLines.add(new OrderLine(sandwich));
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


}
