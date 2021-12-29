package controller;

import model.Order;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import model.OrderLine;

import java.util.HashMap;

public interface Observer {

    void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int OrderCount, boolean orderisinspected, HashMap<OrderLine, Integer> peek, int follownr);

}
