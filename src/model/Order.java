package model;

import java.util.List;

public class Order {
    private List<OrderLine> orders;


    public List<OrderLine> getOrders() {
        return orders;
    }

    public void addOrderLine(OrderLine orders) {
        this.orders.add(orders);
    }
}
