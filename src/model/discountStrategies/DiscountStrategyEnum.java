package model.discountStrategies;

public enum DiscountStrategyEnum {
    DISCOUNT_NONE ("No discount", "model.database.LoadSaveStrategies.SandwichExcelLoadSaveSaveStrategy"),
    DISCOUNT_TENPERCENT ("10% discount", "model.database.LoadSaveStrategies.ToppingExcelLoadSaveSaveStrategy"),
    DISCOUNT_CHEAPEST_SANDWICH_FRE ("Cheapest sandwich for free", "model.database.LoadSaveStrategies.SandwichesTextLoadSaveStrategy");

    private final String name;
    private final String location;

    DiscountStrategyEnum(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }
}
