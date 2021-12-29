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

    private static OrderFacade orderFacade;
    private boolean Orderisinspected;
    private int follownr = 0;
    private Order order = new Order(getfollownr());;

    private final HashMap<String , HashMap<String , Integer>> doneorders = new HashMap<String,  HashMap<String , Integer>>(){{ put("Toppings",new HashMap<>() );put("Sandwiches",new HashMap<>());}};
    private final Map<OrderEvent, List<Observer>> observers = new HashMap<>();
    private final Queue<Order> kitchenQueue = new LinkedList();

    private SandwichDatabase sandwichDatabase;
    private ToppingDatabase toppingDatabase;

    private OrderFacade() {

        this.toppingDatabase = ToppingDatabase.getInstance();
        this.sandwichDatabase = SandwichDatabase.getInstance();

        Arrays.asList(OrderEvent.values()).forEach(orderEvent -> observers.put(orderEvent, new ArrayList<>()));
        toppingDatabase.getToppingSorts().values().forEach(topping -> doneorders.get("Toppings").put(topping.getName(), 0));
        sandwichDatabase.getSandwichSorts().values().forEach(sandwich ->  doneorders.get("Sandwiches").put(sandwich.getName(), 0));
    }

    /* ----------- singleton-------------*/
    public static OrderFacade getInstance() {
        if (orderFacade == null) {
            orderFacade = new OrderFacade();
        }
        return orderFacade;
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
            observer.update(toppingDatabase, sandwichDatabase, order, getOrderCount(), isOrderisinspected() , doneorders, getorderashashmap());
        }
    }

    public void addOrderline(String sandwichName) {
        Sandwich sandwich = sandwichDatabase.getSandwich(sandwichName);
        sandwich.updateStock();
        order.addOrderLine(sandwich);
        notifyObservers(OrderEvent.ADD_SANDWICH);
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
    public void addTopping(int id, String toppingName){
        Topping topping = toppingDatabase.getTopping(toppingName);
        topping.updateStock();
        order.addTopping(id ,topping);
        notifyObservers(OrderEvent.Add_TOPPING);
    }
    public void cancelOrder(){
        this.sandwichDatabase.reset();
        this.toppingDatabase.reset();
        this.order.reset();
    }
    public void endOrder() {
        order.endOrder();
    }
    public void pay() {
        order.pay();
    }
    public void toKitchen(){
        kitchenQueue.add(order);
        order.toKitchen();
        notifyObservers(OrderEvent.ORDER_TO_KITCHEN);
        updatebase();
        sandwichDatabase.save();
        toppingDatabase.save();
        follownr++;
        order = new Order(getfollownr());
    }
    public void startPreparation() {
        setOrderisinspected(true);
        Order order = kitchenQueue.peek();
        order.startPreparation();
        notifyObservers(OrderEvent.START_PREPARATION);
    }
    public void Done() {
        setOrderisinspected(false);
        Order deletedorder = kitchenQueue.remove();
        deletedorder.orderIsDone();
        notifyObservers(OrderEvent.ORDER_IS_DONE);
    }

    public int getfollownr() {
        return follownr;
    }
    public int getOrderCount() {
        return kitchenQueue.size();
    }

    public double getAmount(){
        return order.getTotalPrice();
    }
    public double getDiscountAmount(DiscountStrategyEnum discount){
        return order.getTotalPriceWithDiscount(discount);
    }


    public Order getOrder() {
        return order;
    }
    public Order getTopOfQueue() {
        return kitchenQueue.peek();
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


    public HashMap<String , HashMap<String , Integer>> getdoneorders() {
        return doneorders;
    }
    public HashMap<OrderLine, Integer> getorderashashmap(){
        return kitchenQueue.size() != 0 ? kitchenQueue.peek().giverorderashashmap(): null;
    }
    public HashMap<String, Integer> getStockListSandwiches() {
        return sandwichDatabase.getStockListSandwiches();
    }
    public HashMap<String, Integer> getStockListToppings() {
        return toppingDatabase.getStockListToppings();
    }


    public DiscountStrategyEnum[] getDiscountsEnum() {
        return DiscountStrategyEnum.values();
    }
    public LoadSaveStrategyEnum[] getLoadTypes(){
        return LoadSaveStrategyEnum.values();
    }

    public void setOrderisinspected(boolean orderisinspected) {
        Orderisinspected = orderisinspected;
    }
    public boolean isOrderisinspected() {
        return Orderisinspected;
    }

    public void addOrderlineToDone(){
        for (OrderLine orderline:order.getOrderLines()) {
            doneorders.get("Sandwiches").put(orderline.getSandwichname(), doneorders.get("Sandwiches").get(orderline.getSandwichname()) + 1);
            orderline.getToppingssort().forEach(topping -> doneorders.get("Toppings").put(topping.getName(), doneorders.get("Toppings").get(topping.getName()) + 1));
        }
    }
    public void updatebase(){
        for (OrderLine orderline: order.getOrderLines()) {
            this.sandwichDatabase.getSandwichSorts().get(orderline.getSandwichname()).increamentSold();
            orderline.getToppingssort().forEach(topping ->  this.toppingDatabase.getToppingSorts().get(topping.getName()).increamentSold());
        }
    }

}


