package model.database.LoadSaveStrategies;

import model.Settings;
import model.database.TextLoadSaveTemplate;
import model.database.ToppingDatabase;
import model.domain.DomainException;
import model.domain.Topping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.TreeMap;

public class ToppingsTextLoadSaveStrategy extends TextLoadSaveTemplate<String, Topping> implements LoadSaveStrategy<String, Topping> {

    public ToppingsTextLoadSaveStrategy() {
        try { setReader(new BufferedReader(new FileReader(Objects.requireNonNull(LoadSaveStrategyEnum.getEnumFromString(Settings.getProductFormatReaderSettings() + " Topping")).getFile())));
        }catch (Exception e){ throw new DomainException("Tis weer kapot eh"); }
    }

    @Override
    public TreeMap<String, Topping> load() {
        try { return super.load();
        } catch (Exception ignored) { }
        return null;
    }
    @Override
    public void save() {
        super.save();
    }


    public @Override
    Topping makeObject(String[] tokens) {
        return new Topping(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
    }
    @Override
    public String getKey(String[] tokens) {
        return tokens[0];
    }
    
}
