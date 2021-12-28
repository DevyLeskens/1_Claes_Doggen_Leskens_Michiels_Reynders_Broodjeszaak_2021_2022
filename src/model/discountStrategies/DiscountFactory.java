package model.discountStrategies;

public class DiscountFactory {

    public static DiscountStrategy createLoadSaveStrategy(String fileLocation) {
        String className = fileLocation;
        DiscountStrategy fileInterface = null;
        try {
            Class dbClass = Class.forName(className);
            Object dbObject = dbClass.getConstructor().newInstance();
            fileInterface = (DiscountStrategy) dbObject;
        } catch (Exception ignored) {
        }
        return fileInterface;
    }
}
