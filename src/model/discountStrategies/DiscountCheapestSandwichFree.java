package model.discountStrategies;

import model.Order;
import model.OrderLine;

public class DiscountCheapestSandwichFree implements DiscountStrategy{

    public double calcDiscount(Order order) {
        return order.getCheapest();
    }
}
