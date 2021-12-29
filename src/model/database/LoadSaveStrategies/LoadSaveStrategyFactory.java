package model.database.LoadSaveStrategies;

public class LoadSaveStrategyFactory {

    public static LoadSaveStrategy createLoadSaveStrategy(String naam) {
        LoadSaveStrategy fileInterface = null;
        try {
            Class dbClass = Class.forName(LoadSaveStrategyEnum.getEnumFromString(naam).getLocation());
            Object dbObject = dbClass.getConstructor().newInstance();
            fileInterface = (LoadSaveStrategy) dbObject;
        } catch (Exception ignored) {
        }
        return fileInterface;
    }
}
