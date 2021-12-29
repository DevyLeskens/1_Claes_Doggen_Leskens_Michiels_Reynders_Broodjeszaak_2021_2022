package model.database;

import excel.ExcelPlugin;
import jxl.read.biff.BiffException;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;
import model.domain.Product;


import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;


public abstract class ExcelLoadSaveTemplate<K, V> {


    protected TreeMap<K,V> database;
    protected File reader;


    protected TreeMap<K, V> load() throws IOException, BiffException {
        TreeMap<K, V> returnMap = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getReader()))) {
            ExcelPlugin excelPlugin = new ExcelPlugin();
            ArrayList<ArrayList<String>> input = excelPlugin.read(getReader());
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
    protected void save(TreeMap<K,V> map){
            ExcelPlugin excelPlugin = new ExcelPlugin();
            ArrayList<String> outputLine;
            ArrayList<ArrayList<String>> fullOutput = new ArrayList<>();
            for (V object : map.values()) {
                outputLine = createTextLine(object);
                fullOutput.add(outputLine);
            }
            try {
                excelPlugin.write(getReader(), fullOutput);
            } catch (Exception e) {
                e.printStackTrace();
            }

    }
    protected ArrayList<String> createTextLine(Object object) {
        Product product = (Product) object;
        ArrayList<String> line = new ArrayList<>();
        line.add(product.getName());
        line.add(String.valueOf(product.getPrice()));
        line.add(String.valueOf(product.getStock()));
        line.add(String.valueOf(product.getSold()));
        return line;
    }
    protected abstract V makeObject(ArrayList<String> tokens);
    protected abstract K getKey(ArrayList<String> tokens);
    protected void setReader(File reader) { this.reader = reader; }
    protected File getReader() { return reader; }
}


