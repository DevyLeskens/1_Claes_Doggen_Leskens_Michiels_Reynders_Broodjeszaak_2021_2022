package model.database;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;


public abstract class ExcelLoadSaveTemplate<K, V> {


    protected ProductDatabase<K,V> database;
    protected File reader;


    protected TreeMap<K, V> load() throws IOException, BiffException {
        TreeMap<K, V> returnMap = new TreeMap<K, V>();
        try (BufferedReader reader = new BufferedReader(new FileReader(LoadSaveStrategyEnum.EXCEL_SANDWICH.getFile()))) {
            ExcelPlugin excelPlugin = new ExcelPlugin();
            ArrayList<ArrayList<String>> input = excelPlugin.read(LoadSaveStrategyEnum.EXCEL_SANDWICH.getFile());
            for (ArrayList<String> line : input) {
                V element = makeObject(line);
                K key = getKey(line);
                returnMap.put(key, element);
            }
        } catch (BiffException e) {
            e.printStackTrace();
        }
        return returnMap;
    }

    protected abstract V makeObject(ArrayList<String> tokens);
    protected abstract K getKey(ArrayList<String> tokens);
    protected void setReader(File reader) { this.reader = reader; }
    protected File getReader() { return reader; }
}


/**

 */
