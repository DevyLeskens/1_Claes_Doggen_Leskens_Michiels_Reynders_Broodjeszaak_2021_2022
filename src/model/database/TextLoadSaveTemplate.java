package model.database;

import model.Settings;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.domain.DomainException;
import model.domain.Product;

import java.io.*;
import java.util.Objects;
import java.util.TreeMap;

public abstract class TextLoadSaveTemplate<K, V> {

    protected ProductDatabase<K,V> database;
    protected BufferedReader reader;
    protected TextLoadSaveTemplate() { }

    protected TreeMap<K, V> load(){
        TreeMap<K, V> returnMap = new TreeMap<K, V>();
        try (BufferedReader reader = getReader()) {
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                String[] tokens = line.split(",");
                V element = makeObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key, element);
                line = reader.readLine();
            }
        }catch (Exception e){
           throw new DomainException("tis kapot eh");
        }
        return returnMap;
    }
    protected void save(){
        try {
            FileWriter writer = new FileWriter("src/bestanden/" + database.toString() + "copy.txt");
            for (V product:database.getDatabase().values()) {
                writer.write(((Product) product).getWriteFormat() + "\n");
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    protected abstract V makeObject(String[] tokens);
    protected abstract K getKey(String[] tokens);

    protected BufferedReader getReader() { return reader; }
    protected void setReader(BufferedReader reader) { this.reader = reader; }
}
