package model.database.LoadSaveStrategies;

import model.database.ExcelLoadSaveTemplate;
import model.domain.Sandwich;

import java.util.ArrayList;
import java.util.TreeMap;

public class SandwichExcelLoadSaveSaveStrategy extends ExcelLoadSaveTemplate<String, Sandwich> implements LoadSaveStrategy {

    public SandwichExcelLoadSaveSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        super(loadSaveStrategyEnum);
    }

    @Override
    public Sandwich makeObject(ArrayList<String> tokens) {
        return new Sandwich(tokens.get(0),Double.parseDouble(tokens.get(1)),Integer.parseInt(tokens.get(2)),Integer.parseInt(tokens.get(3)));
    }

    @Override
    public String getKey(ArrayList<String> tokens) {
        return tokens.get(0);
    }

    @Override
    public TreeMap<String, Sandwich> load() {
       try {
           return super.load();
       }catch (Exception ignored){ }
       return null;
    }

    @Override
    public void save() {

    }
}
