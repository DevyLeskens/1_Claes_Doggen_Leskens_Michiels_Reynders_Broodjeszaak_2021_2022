package model.database;

import model.Settings;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Topping;

import java.util.HashMap;
import java.util.TreeMap;

public class ToppingDatabase {

    TreeMap<String, Topping> toppingSorts = new TreeMap<>();

    private static ToppingDatabase toppingDatabase;

    private ToppingDatabase() {
        load();
    }

    /**
     * Singleton design pattern
     */

    public static ToppingDatabase getInstance() {
        if (toppingDatabase == null) {
            toppingDatabase = new ToppingDatabase();
        }
        return toppingDatabase;
    }

    public TreeMap<String, Topping> getToppingSorts() {
        return toppingSorts;
    }

    public Topping getTopping(String name) {
        return toppingSorts.get(name);
    }


    public void load() {
        try {
            this.toppingSorts = LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() == "excel" ? LoadSaveStrategyEnum.EXCEL_TOPPING : LoadSaveStrategyEnum.TEXT_TOPPING).load();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // dummy methode
    public void save(){

    }

    @Override
    public String toString() {
        return "ToppingDatabase{" +
                "toppingSorts=" + toppingSorts +
                '}';
    }

    public HashMap<String, Integer> getStockListToppings() {
        HashMap<String, Integer> stockListToppings = new HashMap<>();
        for (Topping topping : toppingSorts.values()) {
            stockListToppings.put(topping.getName(), topping.getStock());
        }
        return stockListToppings;
    }

    public void setToppingSorts(TreeMap<String, Topping> toppingSorts) {
        this.toppingSorts = toppingSorts;
    }

    public void reset() {
        load();
    }
}
