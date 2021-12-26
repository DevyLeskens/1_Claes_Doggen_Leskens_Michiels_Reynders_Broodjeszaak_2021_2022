package model.states;

import model.Order;

public class StateInPreparation extends OrderState{

    public StateInPreparation(Order order) {
        super(order);
    }

    @Override
    public void done(){
        order.setOrderState(order.getStateIsPrepared());
    }
}
