package model.states;


import model.Order;

public class StateIsTerminated extends OrderState {
    public StateIsTerminated(Order order) {
        super(order);
    }
}
