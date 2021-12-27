package controller;

import model.Order;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;

import java.util.Set;

public interface Observer {

    void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int OrderCount, Set<Order> orderdone);

}
