package model.database;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;


public abstract class ExcelLoadSaveTemplate<K,V>  {

    protected final LoadSaveStrategyEnum loadSaveStrategyEnum;

    protected ExcelLoadSaveTemplate(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        this.loadSaveStrategyEnum = loadSaveStrategyEnum;
    }

    protected TreeMap<K,V> load() throws IOException {
        TreeMap<K,V> returnMap = new TreeMap<K,V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(loadSaveStrategyEnum.getFile()))){
            ExcelPlugin excelPlugin = new ExcelPlugin();
            ArrayList<ArrayList<String>> input = excelPlugin.read(loadSaveStrategyEnum.getFile());
            for (ArrayList<String> line: input) {
                V element = makeObject(line);
                K key = getKey(line);
                returnMap.put(key,element);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return returnMap;
    }
    protected  void save(){

    }

    protected abstract V makeObject(ArrayList<String> tokens);

    protected abstract K getKey(ArrayList<String> tokens);
}
