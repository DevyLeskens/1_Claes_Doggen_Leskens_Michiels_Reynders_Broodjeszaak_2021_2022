package model.database;

import model.Settings;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Sandwich;

import java.util.TreeMap;

public class SandwichDatabase extends ProductDatabase<String, Sandwich> {


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
            setDatabase(LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() + " sandwich").load());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void save(TreeMap<String,Sandwich> map) {
        try {
            LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() + " sandwich").save(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
