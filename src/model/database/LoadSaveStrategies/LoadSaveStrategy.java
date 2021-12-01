package model.database.LoadSaveStrategies;

import java.util.TreeMap;

public interface LoadSaveStrategy {

    TreeMap load();
    void save();
}
