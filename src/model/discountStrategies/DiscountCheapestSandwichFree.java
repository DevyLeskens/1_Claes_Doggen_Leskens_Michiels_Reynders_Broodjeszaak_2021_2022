package model.discountStrategies;

import model.Order;

public class DiscountCheapestSandwichFree implements DiscountStrategy {

    public double calcDiscount(Order order) {
        return order.getCheapestOrderLine();
    }
}
