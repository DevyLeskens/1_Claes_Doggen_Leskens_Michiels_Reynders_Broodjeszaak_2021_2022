package model.database;

import model.domain.Sandwich;

import java.io.*;
import java.util.*;

public class SandwichDatabase {


    TreeMap<String, Sandwich> sandwichsorts = new TreeMap<>();
    private static SandwichDatabase sandwichDatabase;
    private SandwichDatabase(){
        Load();
    }
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
        try {
            Scanner myReader = new Scanner(new File("src/bestanden/broodjes.txt"));
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split(",");
                Sandwich sandwich =  new Sandwich(data[0] , Double.parseDouble(data[1]), Integer.parseInt(data[2]) , Integer.parseInt(data[3]));
                sandwichsorts.put(data[0],sandwich);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("could not find input file.");
            e.printStackTrace();
        }
    }


    public void save(){
            try {
                FileWriter myWriter = new FileWriter("src/bestanden/broodjes.txt");
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
