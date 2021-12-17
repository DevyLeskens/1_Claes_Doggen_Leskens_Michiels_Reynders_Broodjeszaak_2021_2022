package model.states;

import model.Order;

public class StateIsPayed extends OrderState{
    public StateIsPayed(Order order) {
        super(order);
    }
}
