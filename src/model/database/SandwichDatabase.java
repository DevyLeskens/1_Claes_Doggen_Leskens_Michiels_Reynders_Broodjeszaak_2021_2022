package model.database;

import model.Settings;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Sandwich;

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
