package controller;

import model.Order;
import model.Subject;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;

public interface Observer {

    void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order);

}
