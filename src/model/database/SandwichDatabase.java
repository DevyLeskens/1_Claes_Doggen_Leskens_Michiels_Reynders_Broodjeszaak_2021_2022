package model.database;

import model.Order;
import model.OrderLine;
import model.Settings;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Sandwich;

import java.io.*;
import java.util.*;

public class SandwichDatabase {

    TreeMap<String, Sandwich> sandwichSorts = new TreeMap<>();

    private static SandwichDatabase sandwichDatabase;

    private SandwichDatabase() {
        load();
    }

    /**
     * Singleton design pattern
     */

    public static SandwichDatabase getInstance() {
        if (sandwichDatabase == null) {
            sandwichDatabase = new SandwichDatabase();
        }
        return sandwichDatabase;
    }

    public TreeMap<String, Sandwich> getSandwichSorts() {
        return sandwichSorts;
    }

    public void load() {
        try {
            this.sandwichSorts = LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() == "excel" ? LoadSaveStrategyEnum.EXCEL_SANDWICH : LoadSaveStrategyEnum.TEXT_SANDWICH).load();

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

    public Sandwich getSandwich(String name) {
        return sandwichSorts.get(name);
    }

    public HashMap<String, Integer> getStockListSandwiches() {
        HashMap<String, Integer> stockListSandwiches = new HashMap<>();
        for (Sandwich sandwich : sandwichSorts.values()) {
            stockListSandwiches.put(sandwich.getName(), sandwich.getStock());
        }
        return stockListSandwiches;
    }

    @Override
    public String toString() {
        return "SandwichDatabase{" +
                "sandwichSorts=" + sandwichSorts +
                '}';
    }

    public void reset() {
        load();
    }
}
