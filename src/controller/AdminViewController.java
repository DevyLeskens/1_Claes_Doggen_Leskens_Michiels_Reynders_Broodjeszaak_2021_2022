package controller;

import model.Order;
import model.OrderEvent;
import model.OrderFacade;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.SandwichDatabase;
import model.database.ToppingDatabase;
import model.domain.Sandwich;
import model.domain.Topping;
import view.adminPane.AdminView;

import java.util.Collection;
import java.util.HashMap;

import model.discountStrategies.DiscountStrategyEnum;
import view.adminPane.AdminView;
import view.orderMainPane.OrderView;

import java.util.List;
import java.util.Set;



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
    public DiscountStrategyEnum[] getAllDiscounts(){
        return orderFacade.getDiscounts();
    }
    public LoadSaveStrategyEnum[] getLoadTypes() {
        return orderFacade.getLoadTypes();
    }

    @Override
    public void update(ToppingDatabase toppingDatabase, SandwichDatabase sandwichDatabase, Order order, int countrorder, boolean orderisinspected, HashMap<String, HashMap<String, Integer>> orderdone, Order peek) {
        System.out.println(toppingDatabase.toString() + " " + sandwichDatabase.toString() + " " + order.toString());
        orderFacade.addOrderlineToDone();
        adminView.update();
    }

    public Collection<Sandwich> getSandwichDatabase() {
        return  orderFacade.getSandwichDatabase().getSandwichsorts().values();
    }

    public Collection<Topping> getToppingDatabase() {
        return orderFacade.getToppingDatabase().getToppingsorts().values();
    }

    public HashMap<String , HashMap<String , Integer>> getSoldOrders() {
        return orderFacade.getdoneorders();
    }



    public void savePreferences(DiscountStrategyEnum selectedItem, String selectedItem1) {
        OrderViewController orderViewController;

    }

}
