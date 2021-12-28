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


    private boolean Orderisinspected;
    private static int follownr = 0;


    private static OrderFacade orderFacade;
    private ToppingDatabase toppingDatabase;
    private SandwichDatabase sandwichDatabase;
    private Order order;
    private final HashMap<String , HashMap<String , Integer>> doneorders = new HashMap<>();
    private final Map<OrderEvent, List<Observer>> observers = new HashMap<>();
    private final Queue<Order> kitchenQueue = new LinkedList();

    private OrderFacade() {
        this.toppingDatabase = ToppingDatabase.getInstance();
        this.sandwichDatabase = SandwichDatabase.getInstance();
        this.order = new Order();

        for (OrderEvent orderEvent : OrderEvent.values()) {
            observers.put(orderEvent, new ArrayList<>());
        }
        doneorders.put("Toppings", new HashMap<>());
        doneorders.put("Sandwiches", new HashMap<>());
        for (Topping topping : toppingDatabase.getToppingsorts().values()) {
            doneorders.get("Toppings").put(topping.getName(), 0);
        }
        for (Sandwich sandwich : sandwichDatabase.getSandwichsorts().values()) {
            doneorders.get("Sandwiches").put(sandwich.getName(), 0);
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
            observer.update(toppingDatabase, sandwichDatabase, order, getOrderCount(), isOrderisinspected() , doneorders, kitchenQueue.size() != 0 ? kitchenQueue.peek().giverorderashashmap() : null);
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
    public ArrayList<String> getDiscounts() {
        return DiscountStrategyEnum.getDiscounts();
    }
    public DiscountStrategyEnum[] getDiscountsEnum() {
        return DiscountStrategyEnum.values();
    }
    public LoadSaveStrategyEnum[] getLoadTypes(){
        return LoadSaveStrategyEnum.values();
    }


    public void addOrderlineToDone(){
        for (OrderLine orderline:order.getOrderLines()) {
            doneorders.get("Sandwiches").put(orderline.getSandwichname() , doneorders.get("Sandwiches").get(orderline.getSandwichname()) + 1);
            for(Topping topping: orderline.getToppingssort()){
                doneorders.get("Toppings").put(topping.getName() , doneorders.get("Toppings").get(topping.getName()) + 1);
            };
        }
    }

    public void pay() {
        order.pay();
    }

    public void endOrder() {
        order.endOrder();
    }

    public HashMap<String , HashMap<String , Integer>> getdoneorders() {
        return doneorders;
    }
    public void toKitchen(){
        kitchenQueue.add(order);
        order.toKitchen();
        notifyObservers(OrderEvent.ORDER_TO_KITCHEN);
        order = new Order();
    }
    public void startPreparation() {
        setOrderisinspected(true);
        Order order = kitchenQueue.peek();
        order.startPreparation();
        notifyObservers(OrderEvent.START_PREPARATION);
    }
    public void Done() {
        setOrderisinspected(false);
        notifyObservers(OrderEvent.ORDER_IS_DONE);
        Order deletedorder = kitchenQueue.remove();
        deletedorder.orderIsDone();
    }
    public Order getTopOfQueue() {
        return kitchenQueue.peek();
    }

    public boolean isOrderisinspected() {
        return Orderisinspected;
    }

    public void setOrderisinspected(boolean orderisinspected) {
        Orderisinspected = orderisinspected;
    }

    public int getOrderCount() {
        return kitchenQueue.size();
    }
    public HashMap<String , Integer> giverorderashashmap(Order order){
        return order.giverorderashashmap();
    }

}

