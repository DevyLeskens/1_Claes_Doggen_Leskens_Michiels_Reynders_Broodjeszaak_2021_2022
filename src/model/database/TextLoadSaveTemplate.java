package model.database;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public abstract class TextLoadSaveTemplate<K,V>{

    protected final LoadSaveStrategyEnum loadSaveStrategyEnum;

    protected TextLoadSaveTemplate(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        this.loadSaveStrategyEnum = loadSaveStrategyEnum;
    }
    protected TreeMap<K,V> load() throws IOException {
        TreeMap<K,V> returnMap = new TreeMap<K,V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(loadSaveStrategyEnum.getFile()))){
            String line = reader.readLine();
            while (line != null && !line.trim().equals("")) {
                String[] tokens = line.split(",");
                V element = makeObject(tokens);
                K key = getKey(tokens);
                returnMap.put(key,element);
                line = reader.readLine();
            }
        }
        return returnMap;
    }

    protected abstract V makeObject(String[] tokens);

    protected abstract K getKey(String[] tokens);

}
