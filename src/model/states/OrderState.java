package model.states;

import model.Order;

public abstract class OrderState {

    private Order order = new Order();

    protected void addSanchwich() { throw new OrderStateException("Action not permitted in current state"); }

    private void deleteSanchwich() {  throw new OrderStateException("Action not permitted in current state"); }

    private void addIdenticalSandwich() { throw new OrderStateException("Action not permitted in current state"); }

    private void addTopping() {  throw new OrderStateException("Action not permitted in current state"); }

    private void pay() {  throw new OrderStateException("Action not permitted in current state"); }

    private void cancelOrder() {  throw new OrderStateException("Action not permitted in current state"); }

    private void terminate() {  throw new OrderStateException("Action not permitted in current state"); }

    private void sendToKitchen() {   throw new OrderStateException("Action not permitted in current state"); }

    private void startPreparation() {  throw new OrderStateException("Action not permitted in current state"); }

    private void done() {  throw new OrderStateException("Action not permitted in current state"); }

}
