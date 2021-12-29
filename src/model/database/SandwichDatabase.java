package model.database;

import model.Order;
import model.OrderLine;
import model.Settings;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Product;
import model.domain.Sandwich;

import java.io.*;
import java.util.*;

public class SandwichDatabase extends ProductDatabase<String, Sandwich> {

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

    public void load() {
        try {
            setDatabase(LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() == "excel" ? LoadSaveStrategyEnum.EXCEL_SANDWICH : LoadSaveStrategyEnum.TEXT_SANDWICH).load());

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


}
