package model.database.LoadSaveStrategies;

import model.database.ExcelLoadSaveTemplate;
import model.domain.Topping;

import java.util.ArrayList;
import java.util.TreeMap;

public class ToppingExcelLoadSaveSaveStrategy extends ExcelLoadSaveTemplate<String, Topping> implements LoadSaveStrategy<String, Topping> {

    public ToppingExcelLoadSaveSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        super(loadSaveStrategyEnum);
    }

    @Override
    public Topping makeObject(ArrayList<String> tokens) {
        return new Topping(tokens.get(0), Double.parseDouble(tokens.get(1)), Integer.parseInt(tokens.get(2)), Integer.parseInt(tokens.get(3)));
    }

    @Override
    public String getKey(ArrayList<String> tokens) {
        return tokens.get(0);
    }

    @Override
    public TreeMap<String, Topping> load() {
        try { return super.load();
        } catch (Exception ignored) { }
        return null;
    }

    @Override
    public void save() {

    }
}
