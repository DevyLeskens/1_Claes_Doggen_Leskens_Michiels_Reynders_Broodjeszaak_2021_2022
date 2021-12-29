package model.database;

import model.Settings;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Product;

import java.util.HashMap;
import java.util.TreeMap;

public abstract class ProductDatabase<K , V> {


    TreeMap<String, V> database = new TreeMap<>();

    protected ProductDatabase() {
        load();
    }

    public void load() {
        try {
            this.database = LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() == "excel" ? LoadSaveStrategyEnum.EXCEL_SANDWICH : LoadSaveStrategyEnum.TEXT_SANDWICH).load();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void save() {
        try {
            LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() == "excel" ? LoadSaveStrategyEnum.EXCEL_SANDWICH : LoadSaveStrategyEnum.TEXT_SANDWICH).save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setDatabase(TreeMap<String, V> database) {
        this.database = database;
    }
    public TreeMap<String, V> getDatabase() {
        return database;
    }
    public V getProduct(String name) {
        return database.get(name);
    }

    public HashMap<String, Integer> getStockList() {
        HashMap<String, Integer> stockList = new HashMap<>();
        for (V product: getDatabase().values()) {
            stockList.put(((Product) product).getName(), ((Product) product).getStock());
        }
        return stockList;
    }
    public HashMap<String, Integer> getSoldList() {
        HashMap<String, Integer> stockList = new HashMap<>();
        for (V product: getDatabase().values()) {
            stockList.put(((Product) product).getName(), ((Product) product).getSold());
        }
        return stockList;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public void reset() {
        load();
    }
}
