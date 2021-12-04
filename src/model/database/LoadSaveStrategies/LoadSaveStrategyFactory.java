package model.database.LoadSaveStrategies;

public class LoadSaveStrategyFactory<K,V> {
    public LoadSaveStrategy<K,V> createLoadSaveStrategy(LoadSaveStrategyEnum filetypeEnum){
        String klasseNaam = filetypeEnum.getLocatie();
        LoadSaveStrategy<K,V> fileInterface = null;
        try{
            Class dbClass = Class.forName(klasseNaam);
            Object dbObject = dbClass.getConstructor(LoadSaveStrategyEnum.class).newInstance(filetypeEnum);
            fileInterface  = (LoadSaveStrategy) dbObject;
        }
        catch (Exception ignored){}
        return fileInterface;
    }
 }
