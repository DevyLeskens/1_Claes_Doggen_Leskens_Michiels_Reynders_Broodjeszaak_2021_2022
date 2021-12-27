package model.database;

import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.database.LoadSaveStrategies.LoadSaveStrategyFactory;
import model.domain.Sandwich;

import java.io.*;
import java.util.*;

public class SandwichDatabase {

    TreeMap<String, Sandwich> sandwichsorts = new TreeMap<>();


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

    public TreeMap<String, Sandwich> getSandwichsorts() {
        return sandwichsorts;
    }

    public void load() {
        try {
            this.sandwichsorts = LoadSaveStrategyFactory.createLoadSaveStrategy(LoadSaveStrategyEnum.EXCEL_SANDWICH).load();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void save() {
        try {
            FileWriter myWriter = new FileWriter("src/bestanden/sandwiches.xls");
            for (Sandwich sandwich : sandwichsorts.values()) {
                myWriter.write(sandwich.getName() + "," + sandwich.getPrice() + "," + sandwich.getStock() + "," + sandwich.getSold());
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }




    public Sandwich getSandwich(String name) {
        return sandwichsorts.get(name);
    }

    public HashMap<String, Integer> getStockListSandwiches() {
        HashMap<String, Integer> stockListSandwiches = new HashMap<>();
        for (Sandwich sandwich : sandwichsorts.values()) {
            stockListSandwiches.put(sandwich.getName(), sandwich.getStock());
        }
        return stockListSandwiches;
    }


    @Override
    public String toString() {
        return "SandwichDatabase{" +
                "sandwichsorts=" + sandwichsorts +
                '}';
    }

    public void reset() {
       load();
    }
}
