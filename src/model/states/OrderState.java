package model.states;

import model.Order;

public abstract class OrderState {

    Order order;

    public OrderState(Order order) {
        this.order = order;
    }

    public void addSandwich() {
        throw new OrderStateException("Action not permitted in current state");
    }

    public void deleteSandwich() {
        throw new OrderStateException("Action not permitted in current state");
    }

    public void addIdenticalSandwich() {
        throw new OrderStateException("Action not permitted in current state");
    }

    public void addTopping() {
        throw new OrderStateException("Action not permitted in current state");
    }

    public void pay() {
        throw new OrderStateException("Action not permitted in current state");
    }

    public void cancelOrder() {
        throw new OrderStateException("Action not permitted in current state");
    }

    public void terminate() {
        throw new OrderStateException("Action not permitted in current state");
    }

    public void sendToKitchen() {
        throw new OrderStateException("Action not permitted in current state");
    }

    public void startPreparation() {
        throw new OrderStateException("Action not permitted in current state");
    }

    public void done() {
        throw new OrderStateException("Action not permitted in current state");
    }

}
