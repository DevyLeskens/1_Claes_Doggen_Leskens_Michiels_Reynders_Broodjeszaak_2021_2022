package model.database.LoadSaveStrategies;

import model.database.SandwichDatabase;
import model.database.TextLoadSaveTemplate;
import model.database.ToppingDatabase;
import model.domain.Topping;

import java.util.TreeMap;

public class ToppingsTextLoadSaveStrategy extends TextLoadSaveTemplate<String, Topping> implements LoadSaveStrategy<String, Topping> {

    public ToppingsTextLoadSaveStrategy(LoadSaveStrategyEnum loadSaveStrategyEnum) {
        super(loadSaveStrategyEnum);
    }

    public @Override
    Topping makeObject(String[] tokens) {
        return new Topping(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));

    }

    @Override
    public String getKey(String[] tokens) {
        return tokens[0];
    }

    @Override
    public void save() {
        super.save(ToppingDatabase.getInstance().getToppingSorts());
    }

    @Override
    public TreeMap<String, Topping> load() {
        try { return super.load();
        } catch (Exception ignored) { }
        return null;
    }

}
