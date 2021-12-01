package model.database;

import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Sandwich;

import java.io.*;
import java.util.*;

public class SandwichDatabase {


    TreeMap<String, Sandwich> sandwichsorts = new TreeMap<>();

    private static SandwichDatabase sandwichDatabase;
    private SandwichDatabase(){
        Load();
    }
    /** Singleton design pattern */
    public static SandwichDatabase getInstance(){
        if (sandwichDatabase == null) {
            sandwichDatabase = new SandwichDatabase();
        }
        return sandwichDatabase;
    }

    public TreeMap<String, Sandwich> getSandwichsorts() {
        return sandwichsorts;
    }

    public void Load() {
        try { this.sandwichsorts = LoadSaveStrategyFactory.createLoadSaveStrategy(LoadSaveStrategyEnum.EXCEL_SANDWICH).load();}
        catch (Exception e){ System.out.println(e.getMessage()); }
    }

    public void save(){
            try {
                FileWriter myWriter = new FileWriter("src/bestanden/broodjes.xls");
                for (Sandwich sandwich: sandwichsorts.values()) {
                    myWriter.write(sandwich.getName() + "," + sandwich.getPrice()+ "," + sandwich.getStock() + "," + sandwich.getSold());
                }
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
    }
}
