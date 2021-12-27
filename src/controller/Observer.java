package controller;

import model.Order;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import model.domain.Product;

import java.util.HashMap;
import java.util.Set;

public interface Observer {

    void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int OrderCount, HashMap<String , HashMap<String , Integer>> orderdone);

}
