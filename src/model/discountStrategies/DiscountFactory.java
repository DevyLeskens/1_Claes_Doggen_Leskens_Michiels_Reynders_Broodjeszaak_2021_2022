package model.discountStrategies;

import model.database.LoadSaveStrategies.LoadSaveStrategy;
import model.database.LoadSaveStrategies.LoadSaveStrategyEnum;

public class DiscountFactory {

    public static DiscountStrategy createLoadSaveStrategy(String filelocation){
        String klasseNaam = filelocation;
        DiscountStrategy fileInterface = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.getConstructor(DiscountStrategy.class).newInstance();
            fileInterface  = (DiscountStrategy) dbObject;
        }
        catch (Exception ignored){}
        return fileInterface;
    }
}
