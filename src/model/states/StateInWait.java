package model.states;

import model.Order;

public class StateInWait extends OrderState{
    public StateInWait(Order order) {
        super(order);
    }
}
