package model;

import model.database.SandwichDatabase;
import model.domain.Sandwich;
import model.states.OrderState;
import model.states.StateInOrder;

import java.util.ArrayList;
import java.util.List;

public class Order {
    OrderState orderState;
    ArrayList<OrderLine> orderLines;

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
}
