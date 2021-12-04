package model.database;

<<<<<<< HEAD
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
=======
import model.domain.Sandwich;
>>>>>>> parent of ae78113... Working on Story 2
import model.domain.Topping;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class ToppingDatabase {


    TreeMap<String, Topping> toppingsorts = new TreeMap<>();

    private static ToppingDatabase toppingDatabase;
    private ToppingDatabase(){
        Load();
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

    public void Load() {
<<<<<<< HEAD
        try {
            this.toppingsorts = new LoadSaveStrategyFactory().createLoadSaveStrategy(LoadSaveStrategyEnum.TEXT_TOPPING).load();
        } catch (Exception e){ System.out.println(e.getMessage()); }
=======
        try { this.toppingsorts = new ToppingsTekstLoadSave().load(new File("src/bestanden/beleg.txt")); }
        catch (Exception e){ System.out.println(e.getMessage()); }
>>>>>>> parent of ae78113... Working on Story 2
    }
    // dummy methode
    public void save(){
        try {
            FileWriter myWriter = new FileWriter("src/bestanden/broodjes.txt");
            for (Topping topping: toppingsorts.values()) {
                myWriter.write(topping.getName() + "," + topping.getPrice()+ "," + topping.getStock() + "," + topping.getSold());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
