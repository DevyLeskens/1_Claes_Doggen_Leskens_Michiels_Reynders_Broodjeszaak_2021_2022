package model;

import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import model.discountStrategies.DiscountStrategyEnum;
import model.domain.Sandwich;

import controller.Observer;
import model.domain.Topping;

import java.util.*;

public class OrderFacade implements Subject {


    private static int follownr = 0;
    private int orderCount = 0;
    private static OrderFacade orderFacade;
    private ToppingDatabase toppingDatabase;
    private SandwichDatabase sandwichDatabase;
    private Order order;
    private final Set<Order> orderdone = new HashSet<>();
    private final Map<OrderEvent, List<Observer>> observers = new HashMap<>();
    private final Queue<Order> kitchenQueue = new LinkedList();

    private OrderFacade() {
        this.toppingDatabase = ToppingDatabase.getInstance();
        this.sandwichDatabase = SandwichDatabase.getInstance();
        this.order = new Order();

        for (OrderEvent orderEvent : OrderEvent.values()) {
            observers.put(orderEvent, new ArrayList<>());
        }
    }

    /* ----------- singleton-------------*/
    public static OrderFacade getInstance() {
        if (orderFacade == null) {
            orderFacade = new OrderFacade();
        }
        return orderFacade;
    }

    public ToppingDatabase getToppingDatabase() {
        return toppingDatabase;
    }

    public SandwichDatabase getSandwichDatabase() {
        return sandwichDatabase;
    }

    public void cancelOrder(){
        this.sandwichDatabase.reset();
        this.toppingDatabase.reset();
        this.order.reset();
    }

    public void toKitchen(){
        kitchenQueue.add(order);
        cancelOrder();
        this.sandwichDatabase.reset();
        this.toppingDatabase.reset();
        order = new Order();
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public void registerObserver(OrderEvent orderEvent, Observer observer) {
        observers.get(orderEvent).add(observer);
    }

    @Override
    public void removeObserver(OrderEvent orderEvent, Observer o) {
        observers.get(orderEvent).remove(o);
    }

    @Override
    public void notifyObservers(OrderEvent orderEvent) {
        for (Observer observer : observers.get(orderEvent)) {
            observer.update(toppingDatabase, sandwichDatabase, order, orderCount, orderdone);
        }
    }
    public void addOrderline(String sandwichName) {
        Sandwich sandwich = sandwichDatabase.getSandwich(sandwichName);
        sandwich.updateStock();
        order.addOrderLine(sandwich);
        notifyObservers(OrderEvent.ADD_SANDWICH);
    }
    public void addTopping(int id, String toppingName){
        Topping topping = toppingDatabase.getTopping(toppingName);
        topping.updateStock();
        order.addTopping(id ,topping);
        notifyObservers(OrderEvent.ADD_TOPING);
    }
    public void addIdenticalSandwich(int id){
       if(order.getOrderLines().size() > 0) {
           order.addIdenticalSandwich(id);
       }
       notifyObservers(OrderEvent.ADD_IDENTICAL_SANDWICH);
    }
    public void deleteSandwich(int id){
       order.deleteSandwich(id);
       notifyObservers(OrderEvent.DELETE_SANDWICH);
    }

    public List<OrderLine> getOrderLines() {
        return order.getOrderLines();
    }

    public HashMap<String, Integer> getStockListSandwiches() {
        return sandwichDatabase.getStockListSandwiches();
    }
    public HashMap<String, Integer> getStockListToppings() {
        return toppingDatabase.getStockListToppings();
    }
    public double getAmount(){
        return order.getTotalPrice();
    }

    public double getDiscountAmount(DiscountStrategyEnum discount){
        return order.getTotalPriceWithDiscount(discount);
    }

    public static int getNextfollownrAndIncrease() {
        follownr++;
        return follownr;
    }
    public int getfollownr() {
        return follownr;
    }
    public DiscountStrategyEnum[] getDiscounts() {
        return DiscountStrategyEnum.values();
    }

    public void increaseOrderCount() {
        orderCount++;
        notifyObservers(OrderEvent.ORDER_TO_KITCHEN);
    }
    public int getOrderCount() {
        return orderCount;
    }
    public void decreaseOrderCount() {
        orderCount--;
    }
    public void addOrderlineToDone(){
        orderdone.add(order);
    }
}

