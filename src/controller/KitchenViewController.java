package controller;

import model.OrderFacade;
import view.KitchenPane.KitchenView;

public class KitchenViewController {

    OrderFacade orderFacade = OrderFacade.getInstance();
    KitchenView kitchenView = new KitchenView();

}
