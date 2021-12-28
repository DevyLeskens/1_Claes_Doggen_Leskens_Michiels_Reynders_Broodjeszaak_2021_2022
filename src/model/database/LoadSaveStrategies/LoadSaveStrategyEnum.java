package model.database.LoadSaveStrategies;

import java.io.File;

public enum LoadSaveStrategyEnum {

    EXCEL_SANDWICH("Excel Sandwich", "model.database.LoadSaveStrategies.SandwichExcelLoadSaveSaveStrategy", new File("src/bestanden/sandwiches.xls")),
    EXCEL_TOPPING("Excel Topping", "model.database.LoadSaveStrategies.ToppingExcelLoadSaveSaveStrategy", new File("src/bestanden/toppings.xls")),
    TEXT_SANDWICH("Text Sandwich", "model.database.LoadSaveStrategies.SandwichesTextLoadSaveStrategy", new File("src/bestanden/sandwiches.txt")),
    TEXT_TOPPING("Text Topping", "model.database.LoadSaveStrategies.ToppingsTextLoadSaveStrategy", new File("src/bestanden/toppings.txt"));

    private final String name;
    private final String location;
    private final File file;

    LoadSaveStrategyEnum(String name, String location, File file) {
        this.name = name;
        this.location = location;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return getName();
    }
}
