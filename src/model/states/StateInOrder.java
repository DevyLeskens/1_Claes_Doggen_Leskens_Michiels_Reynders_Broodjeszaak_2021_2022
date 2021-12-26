package model.states;

import model.Order;

public class StateInOrder extends OrderState {

    public StateInOrder(Order order) {
        super(order);
    }

    @Override
    public void addSanchwich() {
    }
    @Override
    public void terminate(){
         order.setOrderState(order.getStateIsTerminated());
    }
}
