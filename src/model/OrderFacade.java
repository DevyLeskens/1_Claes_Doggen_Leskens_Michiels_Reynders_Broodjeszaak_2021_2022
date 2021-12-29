package model;

import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import model.discountStrategies.DiscountStrategyEnum;
import model.domain.Sandwich;

import controller.Observer;
import model.domain.Topping;

import java.util.*;

public class OrderFacade implements Subject {

    public static int sandwichCount = 0;
    private int followNr = 1;
    private boolean orderIsInspected;
    private static OrderFacade orderFacade;
    private Order order = new Order(getFollowNr());

    private final Map<OrderEvent, List<Observer>> observers = new HashMap<>();
    private final Queue<Order> kitchenQueue = new LinkedList<Order>();

    private final SandwichDatabase sandwichDatabase = SandwichDatabase.getInstance();
    private final ToppingDatabase toppingDatabase = ToppingDatabase.getInstance();

    private OrderFacade() {
    }

    /* ----------- singleton-------------*/
    public static OrderFacade getInstance() {
        if (orderFacade == null) {
            orderFacade = new OrderFacade();
        }
        return orderFacade;
    }

    @Override
    public void notifyObservers(OrderEvent orderEvent) {
        for (Observer observer : observers.computeIfAbsent(orderEvent, k -> new ArrayList<>())) {
            observer.update(toppingDatabase, sandwichDatabase, order, getOrderCount(), isOrderIsInspected(), getOrderAsHashMap(), getTopQueueFollowNr());
        }
    }

    @Override
    public void registerObserver(OrderEvent orderEvent, Observer observer) {
        observers.computeIfAbsent(orderEvent, k -> new ArrayList<>()).add(observer);
    }

    @Override
    public void removeObserver(OrderEvent orderEvent, Observer o) {
        observers.get(orderEvent).remove(o);
    }

    public void addOrderLine(String sandwichName) {
        Sandwich sandwich = sandwichDatabase.getProduct(sandwichName);
        order.addOrderLine(sandwich);
        notifyObservers(OrderEvent.ADD_SANDWICH);
    }

    public void addIdenticalSandwich(int id) {
        order.addIdenticalSandwich(id);
        notifyObservers(OrderEvent.ADD_IDENTICAL_SANDWICH);
    }

    public void deleteSandwich(int id) {
        order.deleteOrderLine(id);
        notifyObservers(OrderEvent.DELETE_SANDWICH);
    }

    public void addTopping(int id, String toppingName) {
        Topping topping = toppingDatabase.getProduct(toppingName);
        order.addTopping(id, topping);
        notifyObservers(OrderEvent.Add_TOPPING);
    }

    public void cancelOrder() {
        this.sandwichDatabase.reset();
        this.toppingDatabase.reset();
        this.order.reset();
        notifyObservers(OrderEvent.CANCEL_ORDER);
    }

    public void endOrder() {
        order.endOrder();
        notifyObservers(OrderEvent.TERMINATE_ORDER);
    }

    public void pay() {
        order.pay();
    }

    public void toKitchen() {
        kitchenQueue.add(order);
        order.toKitchen();
        notifyObservers(OrderEvent.ORDER_TO_KITCHEN);
        followNr++;
        sandwichDatabase.save(sandwichDatabase.getDatabase());
        toppingDatabase.save(toppingDatabase.getDatabase());
        order = new Order(getFollowNr());
    }

    public void startPreparation() {
        setOrderIsInspected(true);
        Order order = getTopOfQueue();
        order.startPreparation();
        notifyObservers(OrderEvent.START_PREPARATION);
    }

    public void Done() {
        setOrderIsInspected(false);
        Order deletedOrder = kitchenQueue.remove();
        deletedOrder.orderIsDone();
        notifyObservers(OrderEvent.ORDER_IS_DONE);
    }

    public int getSandwichCount() { return order.getOrderLines().size(); }

    public int getTopQueueFollowNr() {
        return kitchenQueue.size() != 0 ? getTopOfQueue().getFollowNr() : 0;
    }

    public int getFollowNr() {
        return followNr;
    }

    public int getOrderCount() {
        return kitchenQueue.size();
    }

    public double getAmount() {
        return order.getTotalPrice();
    }

    public double getDiscountAmount(DiscountStrategyEnum discount) {
        return order.getTotalPriceWithDiscount(discount);
    }

    public Order getOrder() {
        return order;
    }

    public Order getTopOfQueue() {
        return kitchenQueue.size() != 0 ? kitchenQueue.peek() : null;
    }

    public ToppingDatabase getToppingDatabase() {
        return toppingDatabase;
    }

    public SandwichDatabase getSandwichDatabase() {
        return sandwichDatabase;
    }

    public ArrayList<String> getDiscounts() {
        return DiscountStrategyEnum.getDiscounts();
    }

    public ArrayList<OrderLine> getOrderLines() {
        return order.getOrderLines();
    }

    public HashMap<String, HashMap<String, Integer>> getStockAsMap() {
        return new HashMap<String, HashMap<String, Integer>>() {{
            put("Toppings", getToppingDatabase().getSoldList());
            put("Sandwiches", getSandwichDatabase().getSoldList());
        }};
    }

    public HashMap<OrderLine, Integer> getOrderAsHashMap() {
        return kitchenQueue.size() != 0 ? getTopOfQueue().giveOrderAsHashMap() : null;
    }

    public HashMap<String, Integer> getStockListSandwiches() {
        return sandwichDatabase.getStockList();
    }

    public HashMap<String, Integer> getStockListToppings() {
        return toppingDatabase.getStockList();
    }

    public DiscountStrategyEnum[] getDiscountsEnum() {
        return DiscountStrategyEnum.values();
    }

    public LoadSaveStrategyEnum[] getLoadTypes() {
        return LoadSaveStrategyEnum.values();
    }

    public boolean isOrderIsInspected() {
        return orderIsInspected;
    }

    public void setOrderIsInspected(boolean orderIsInspected) {
        this.orderIsInspected = orderIsInspected;
    }

    public void updateBase() {
        for (OrderLine orderline : order.getOrderLines()) {
            this.sandwichDatabase.getDatabase().get(orderline.getSandwichname()).incrementSold();
            orderline.getToppingsSort().forEach(topping -> this.toppingDatabase.getDatabase().get(topping.getName()).incrementSold());
        }
    }



}


