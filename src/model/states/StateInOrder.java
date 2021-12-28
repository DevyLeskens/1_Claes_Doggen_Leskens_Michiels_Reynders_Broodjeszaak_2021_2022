package model.states;

import model.Order;

public class StateInOrder extends OrderState {

    public StateInOrder(Order order) {
        super(order);
    }

    @Override
    public void addSandwich() {
    }

    @Override
    public void deleteSandwich() {
    }

    @Override
    public void addIdenticalSandwich() {
    }

    @Override
    public void addTopping() {
    }

    @Override
    public void terminate() {
        order.setOrderState(order.getStateIsTerminated());
    }

    @Override
    public void cancelOrder() {
        order.setOrderState(order.getStateInOrder());
    }
}
