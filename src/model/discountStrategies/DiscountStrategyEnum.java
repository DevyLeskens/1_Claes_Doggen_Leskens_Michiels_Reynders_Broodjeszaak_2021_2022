package model.discountStrategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public enum DiscountStrategyEnum {
    DISCOUNT_NONE("No discount", "model.discountStrategies.DiscountNone"),
    DISCOUNT_TEN_PERCENT("10% discount", "model.discountStrategies.DiscountTenPercent"),
    DISCOUNT_CHEAPEST_SANDWICH_FREE("Cheapest sandwich for free", "model.discountStrategies.DiscountCheapestSandwichFree");

    private final String name;
    private final String location;

    DiscountStrategyEnum(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public static DiscountStrategyEnum getEnumFromString(String name){
        for (DiscountStrategyEnum discount: DiscountStrategyEnum.values()) {
            if(discount.getName().equals(name)){return discount;}
        }return null;
    }
    public static ArrayList<String>getDiscounts(){
        return Arrays.stream(DiscountStrategyEnum.values()).map(DiscountStrategyEnum::getName).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        return name;
    }
}
