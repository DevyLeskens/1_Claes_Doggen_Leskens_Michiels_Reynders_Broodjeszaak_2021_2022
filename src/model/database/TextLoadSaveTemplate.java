package model.database;

import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.domain.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

public abstract class TextLoadSaveTemplate<K, V> {

    protected final LoadSaveStrategyEnum loadSaveStrategyEnum;

    protected TextLoadSaveTemplate(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        this.loadSaveStrategyEnum = loadSaveStrategyEnum;
    }

    protected TreeMap<K, V> load() throws IOException {
        TreeMap<K, V> returnMap = new TreeMap<K, V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(loadSaveStrategyEnum.getFile()))) {
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                String[] tokens = line.split(",");
                V element = makeObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key, element);
                line = reader.readLine();
            }
        }
        return returnMap;
    }

    protected void save(TreeMap<K, V> database, String name) {
        try {
            FileWriter writer = new FileWriter("src/bestanden/" + name + ".txt");
            for (V product : database.values()) {
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

}
