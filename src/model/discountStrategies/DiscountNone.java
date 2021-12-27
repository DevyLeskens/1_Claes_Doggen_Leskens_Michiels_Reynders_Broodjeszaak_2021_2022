package model.discountStrategies;

import model.Order;

public class DiscountNone implements DiscountStrategy{

    public double calcDiscount(Order order) {
        return 0;
    }
}
