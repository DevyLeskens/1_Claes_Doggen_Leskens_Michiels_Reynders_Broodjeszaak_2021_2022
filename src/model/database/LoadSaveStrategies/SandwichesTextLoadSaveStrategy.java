package model.database.LoadSaveStrategies;

import model.database.SandwichDatabase;
import model.database.TextLoadSaveTemplate;
import model.domain.Sandwich;

import java.util.TreeMap;

public class SandwichesTextLoadSaveStrategy extends TextLoadSaveTemplate<String, Sandwich> implements LoadSaveStrategy<String, Sandwich> {

    public SandwichesTextLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        super(loadSaveStrategyEnum);
    }

    @Override
    public Sandwich makeObject(String[] tokens) {
        return new Sandwich(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
    }

    @Override
    public String getKey(String[] tokens) {
        return tokens[0];
    }

    @Override
    public TreeMap<String, Sandwich> load() {
        try {
            return super.load();
        } catch (Exception ignored) {
        }
        return null;
    }

    @Override
    public void save() {
        super.save(SandwichDatabase.getInstance().getDatabase(), "sandwichescopy");
    }
}
