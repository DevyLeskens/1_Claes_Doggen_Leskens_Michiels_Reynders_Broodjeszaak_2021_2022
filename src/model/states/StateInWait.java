package model.states;

import model.Order;

public class StateInWait extends OrderState {
    public StateInWait(Order order) {
        super(order);
    }

    @Override
    public void addSandwich() {
        order.setOrderState(order.getStateInOrder());
    }

    @Override
    public void cancelOrder() {
        order.setOrderState(order.getStateIsCanceled());
    }
}
