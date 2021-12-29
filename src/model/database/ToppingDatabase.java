package model.database;

import model.Settings;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Topping;

import java.util.HashMap;
import java.util.TreeMap;

public class ToppingDatabase extends ProductDatabase<String , Topping> {


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

    public void load() {
        try {
            setDatabase(LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() + " topping").load());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    // dummy methode
    public void save(TreeMap<String,Topping> map){
        try {
         LoadSaveStrategyFactory.createLoadSaveStrategy(Settings.getProductFormatReaderSettings() + " topping").save(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
