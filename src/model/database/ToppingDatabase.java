package model.database;

import model.domain.Sandwich;
import model.domain.Topping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public class ToppingDatabase {


    TreeMap<String, Topping> toppingsorts = new TreeMap<>();

    private static ToppingDatabase toppingDatabase;
    private ToppingDatabase(){
        Load();
    }

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
        try { this.toppingsorts = new ToppingsTekstLoadSave().load(new File("src/bestanden/broodjes.txt")); }
        catch (Exception e){ System.out.println(e.getMessage()); }
    }

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
