package model.database.LoadSaveStrategies;

import model.OrderFacade;
import model.Settings;
import model.database.ExcelLoadSaveTemplate;
import model.database.ToppingDatabase;
import model.domain.DomainException;
import model.domain.Topping;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeMap;

public class ToppingExcelLoadSaveSaveStrategy extends ExcelLoadSaveTemplate<String, Topping> implements LoadSaveStrategy<String, Topping> {

    public ToppingExcelLoadSaveSaveStrategy() {
        try { setReader((Objects.requireNonNull(LoadSaveStrategyEnum.getEnumFromString(Settings.getProductFormatReaderSettings() + " Topping"))).getFile());
        }catch (Exception e){ throw new DomainException("Tis weer kapot eh"); }

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
        try {
            return super.load();
        } catch (Exception ignored) {
        }
        return null;
    }



    @Override
    public void save(TreeMap<String , Topping> map) {
       super.save(map);
    }
}
