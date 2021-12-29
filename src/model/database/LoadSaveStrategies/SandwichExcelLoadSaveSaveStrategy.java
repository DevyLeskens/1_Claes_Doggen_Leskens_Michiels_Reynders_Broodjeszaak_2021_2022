package model.database.LoadSaveStrategies;

import model.OrderFacade;
import model.Settings;
import model.database.ExcelLoadSaveTemplate;
import model.database.SandwichDatabase;
import model.domain.DomainException;
import model.domain.Sandwich;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

public class SandwichExcelLoadSaveSaveStrategy extends ExcelLoadSaveTemplate<String, Sandwich> implements LoadSaveStrategy<String, Sandwich> {

    public SandwichExcelLoadSaveSaveStrategy() {
        try { setReader((Objects.requireNonNull(
                LoadSaveStrategyEnum.getEnumFromString(Settings.getProductFormatReaderSettings() + " Sandwich"))).getFile());
        }catch (Exception e){
            throw new DomainException("Tis weer kapot eh");
        }

    }

    @Override
    public Sandwich makeObject(ArrayList<String> tokens) {
        return new Sandwich(tokens.get(0), Double.parseDouble(tokens.get(1)), Integer.parseInt(tokens.get(2)), Integer.parseInt(tokens.get(3)));
    }

    @Override
    public String getKey(ArrayList<String> tokens) {
        return tokens.get(0);
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
    public void save(TreeMap<String,Sandwich> map) {
        super.save(map);
    }
}
