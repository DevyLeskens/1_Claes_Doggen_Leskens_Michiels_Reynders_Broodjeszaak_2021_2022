package model.database;

import model.domain.Sandwich;

import java.io.*;
import java.util.*;

public class SandwichDatabase {
    public Set<Sandwich> kindOfSandwich;


    public SandwichDatabase(){
        readLinesFromFile();
    }
    public void readLinesFromFile() {
        try (Scanner scanner = new Scanner(new File("src/bestanden/broodjes.xls"))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                int stock = Integer.parseInt(parts[2]);
                int sold = Integer.parseInt(parts[3]);
                Sandwich sandwich = new Sandwich(name, price, stock, sold);
                kindOfSandwich.add(sandwich);
                System.out.println(kindOfSandwich);
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    public Set<Sandwich> getKindOfSandwich() {
        return kindOfSandwich;
    }
}
