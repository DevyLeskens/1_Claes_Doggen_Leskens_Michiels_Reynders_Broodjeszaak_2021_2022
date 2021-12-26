package model.states;


import model.Order;

public class StateIsTerminated extends OrderState {
    public StateIsTerminated(Order order) {
        super(order);
    }

    @Override
    public void pay(){
        order.setOrderState(order.getStateIsPayed());
    }

    @Override
    public void cancelOrder(){
        order.setOrderState(order.getStateIsCanceled());
    }
}
