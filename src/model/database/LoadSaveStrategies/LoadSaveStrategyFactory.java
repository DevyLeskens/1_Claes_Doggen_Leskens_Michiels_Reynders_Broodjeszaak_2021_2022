package model.database.LoadSaveStrategies;

public class LoadSaveStrategyFactory {
    public static LoadSaveStrategy createLoadSaveStrategy(LoadSaveStrategyEnum filetypeEnum){
        String klasseNaam = filetypeEnum.getLocatie();
        LoadSaveStrategy fileInterface = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.getConstructor(LoadSaveStrategyEnum.class).newInstance(filetypeEnum);
            fileInterface  = (LoadSaveStrategy) dbObject;
        }
        catch (Exception ignored){}
        return fileInterface;
    }
 }
