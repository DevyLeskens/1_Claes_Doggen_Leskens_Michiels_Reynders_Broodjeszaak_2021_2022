package model.database;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

<<<<<<< HEAD:src/model/database/TextLoadSaveTemplate.java
public abstract class TextLoadSaveTemplate<K,V>{

    protected final LoadSaveStrategyEnum loadSaveStrategyEnum;
=======
public abstract class TekstLoadTemplate <K,V>{
>>>>>>> parent of ae78113... Working on Story 2:src/model/database/TekstLoadTemplate.java

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
