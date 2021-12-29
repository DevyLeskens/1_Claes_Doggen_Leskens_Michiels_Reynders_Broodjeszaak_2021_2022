package model.database.LoadSaveStrategies;

import java.util.TreeMap;

public interface LoadSaveStrategy<K, V> {

    TreeMap<K, V> load();
    void save();
}
