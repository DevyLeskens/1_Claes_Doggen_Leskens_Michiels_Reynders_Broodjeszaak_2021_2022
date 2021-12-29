package controller;

import model.*;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import model.domain.Sandwich;
import model.domain.Topping;
import view.adminPane.AdminView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


public class AdminViewController implements Observer {

    private AdminView adminView;
    private final OrderFacade orderFacade = OrderFacade.getInstance();

    public AdminViewController(OrderFacade orderFacade) {
        orderFacade.registerObserver(OrderEvent.ORDER_TO_KITCHEN, this);
    }
    public void savePreferences(String format, String discount) {
        Settings.setProperties(format , discount);
    }
    public void setView(AdminView view) { this.adminView = view; }

    public HashMap<String , HashMap<String , Integer>> getSoldOrders() {
        return getOrderFacade().getStockAsMap();
    }
    public Collection<Sandwich> getSandwichDatabase() { return  getOrderFacade().getSandwichDatabase().getDatabase().values(); }
    public Collection<Topping> getToppingDatabase() { return getOrderFacade().getToppingDatabase().getDatabase().values(); }
    public String getPreferredDiscountStrategy(){
        return Settings.getPreferredDiscountStrategySettings();
    }
    public String getProductFormatReader(){
        return Settings.getProductFormatReaderSettings();
    }
    public ArrayList<String> getAllDiscounts(){ return getOrderFacade().getDiscounts(); }
    public OrderFacade getOrderFacade() {
        return orderFacade;
    }

    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int countrorder, boolean orderisinspected, HashMap<OrderLine, Integer> peek, int follownr) {
        System.out.println(toppingDatabase.toString() + " " + sandwichDatabase.toString() + " " + order.toString());
        adminView.update();
    }
}
