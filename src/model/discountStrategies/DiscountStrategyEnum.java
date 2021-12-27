package model.discountStrategies;

public enum DiscountStrategyEnum {
    DISCOUNT_NONE ("No discount", "model.discountStrategies.DiscountNone"),
    DISCOUNT_TEN_PERCENT ("10% discount", "model.discountStrategies.DiscountTenPercent"),
    DISCOUNT_CHEAPEST_SANDWICH_FREE ("Cheapest sandwich for free", "model.discountStrategies.DiscountCheapestSandwichFree");

    private final String name;
    private final String location;

    DiscountStrategyEnum(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
}
