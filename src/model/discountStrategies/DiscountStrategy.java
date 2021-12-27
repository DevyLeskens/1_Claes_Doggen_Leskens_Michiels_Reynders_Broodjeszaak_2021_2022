package model.discountStrategies;

import model.Order;

public interface DiscountStrategy {
    double calcDiscount(Order order);
}
