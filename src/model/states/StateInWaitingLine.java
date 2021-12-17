package model.states;

import model.Order;

public class StateInWaitingLine extends OrderState{
    public StateInWaitingLine(Order order) {
        super(order);
    }
}
