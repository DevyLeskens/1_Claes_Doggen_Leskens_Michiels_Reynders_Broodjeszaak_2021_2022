package model.states;

import model.Order;

public class StateIsPrepared extends OrderState{
    public StateIsPrepared(Order order) {
        super(order);
    }
}
