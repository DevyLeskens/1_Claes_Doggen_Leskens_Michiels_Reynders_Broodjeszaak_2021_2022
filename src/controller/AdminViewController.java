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

    public void setView(AdminView view) {
        this.adminView = view;
    }

    public OrderFacade getOrderFacade() {
        return orderFacade;
    }
    public ArrayList<String> getAllDiscounts(){
        return orderFacade.getDiscounts();
    }
    public LoadSaveStrategyEnum[] getLoadTypes() {
        return orderFacade.getLoadTypes();
    }

    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int countrorder, boolean orderisinspected, HashMap<String, HashMap<String, Integer>> orderdone, HashMap<OrderLine, Integer> peek) {
        System.out.println(toppingDatabase.toString() + " " + sandwichDatabase.toString() + " " + order.toString());
        orderFacade.addOrderlineToDone();
        adminView.update();
    }

    public Collection<Sandwich> getSandwichDatabase() {
        return  orderFacade.getSandwichDatabase().getSandwichSorts().values();
    }

    public Collection<Topping> getToppingDatabase() {
        return orderFacade.getToppingDatabase().getToppingSorts().values();
    }

    public HashMap<String , HashMap<String , Integer>> getSoldOrders() {
        return orderFacade.getdoneorders();
    }



    public void savePreferences(String format, String discount) {
        Settings.setProperties(format , discount);
    }
    public String getPreferredDiscountStrategy(){
       return Settings.getPreferredDiscountStrategySettings();
    }
    public String getProductFormatReader(){
        return Settings.getProductFormatReaderSettings();
    }


}
