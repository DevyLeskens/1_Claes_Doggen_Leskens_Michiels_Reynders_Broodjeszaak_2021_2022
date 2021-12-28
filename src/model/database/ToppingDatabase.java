package model.database;

import model.Settings;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Topping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class ToppingDatabase {


    TreeMap<String, Topping> toppingsorts = new TreeMap<>();

    private static ToppingDatabase toppingDatabase;
    private ToppingDatabase(){
        load();
    }
    /** Singleton design pattern */
    public static ToppingDatabase getInstance(){
        if (toppingDatabase == null) {
            toppingDatabase = new ToppingDatabase();
        }
        return toppingDatabase;
    }

    public TreeMap<String, Topping> getToppingsorts() {
        return toppingsorts;
    }

    public Topping getTopping(String name) {
        return toppingsorts.get(name);
    }


    public void load() {
        try {
            this.toppingsorts = LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() == "excel" ? LoadSaveStrategyEnum.EXCEL_TOPPING : LoadSaveStrategyEnum.TEXT_TOPPING).load();

        } catch (Exception e){ System.out.println(e.getMessage()); }
    }
    // dummy methode
    public void save(){

    }

    @Override
    public String toString() {
        return "ToppingDatabase{" +
                "toppingsorts=" + toppingsorts +
                '}';
    }

    public HashMap<String, Integer> getStockListToppings() {
        HashMap<String, Integer> stockListToppings = new HashMap<>();
        for (Topping topping : toppingsorts.values()) {
            stockListToppings.put(topping.getName(), topping.getStock());
        }
        return stockListToppings;
    }

    public void setToppingsorts(TreeMap<String, Topping> toppingsorts) {
        this.toppingsorts = toppingsorts;
    }
    public void reset() {
        load();
    }
}
