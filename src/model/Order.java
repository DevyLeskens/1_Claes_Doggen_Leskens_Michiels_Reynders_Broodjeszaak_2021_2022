package model;

import model.database.SandwichDatabase;
import model.domain.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class Order {
    ArrayList<OrderLine> orderLines;

    public Order() {
        orderLines = new ArrayList<>();
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void addOrderLine(Sandwich sandwich) {
        this.orderLines.add(new OrderLine(sandwich));
    }
}
