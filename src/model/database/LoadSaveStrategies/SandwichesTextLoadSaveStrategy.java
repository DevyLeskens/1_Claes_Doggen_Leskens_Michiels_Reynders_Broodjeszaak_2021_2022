package model.database.LoadSaveStrategies;

import model.Settings;
import model.database.SandwichDatabase;
import model.database.TextLoadSaveTemplate;
import model.domain.DomainException;
import model.domain.Sandwich;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;
import java.util.TreeMap;

public class SandwichesTextLoadSaveStrategy extends TextLoadSaveTemplate<String, Sandwich> implements LoadSaveStrategy<String, Sandwich> {

    public SandwichesTextLoadSaveStrategy(){
       try { setReader(new BufferedReader(new FileReader(Objects.requireNonNull(LoadSaveStrategyEnum.getEnumFromString(Settings.getProductFormatReaderSettings() + " Sandwich")).getFile())));
       }catch (Exception e){
           throw new DomainException("Tis weer kapot eh");
       }
    }
    @Override
    public TreeMap<String, Sandwich> load() { return super.load(); }
    @Override
    public void save() { super.save(); }
    @Override
    public String getKey(String[] tokens) { return tokens[0]; }
    @Override
    public Sandwich makeObject(String[] tokens) { return new Sandwich(tokens[0], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])); }

}
