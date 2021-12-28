package model.discountStrategies;

import model.Order;

public class DiscountTenPercent implements DiscountStrategy {

    public double calcDiscount(Order order) {
        return order.getTotalPrice() * 0.10;
    }
}
