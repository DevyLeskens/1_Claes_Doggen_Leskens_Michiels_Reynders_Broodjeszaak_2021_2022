package controller;

import model.Order;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;

import java.util.HashMap;

public interface Observer {

    void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int countOrder, boolean orderIsInspected, HashMap<String, HashMap<String, Integer>> orderDone, HashMap<String, Integer> peek);

}
