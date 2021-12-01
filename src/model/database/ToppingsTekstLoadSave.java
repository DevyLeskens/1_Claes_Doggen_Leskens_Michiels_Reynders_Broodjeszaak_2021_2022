package model.database;

import model.domain.Sandwich;
import model.domain.Topping;

public class ToppingsTekstLoadSave extends TekstLoadTemplate<String, Topping>{
    @Override
    Topping maakObject(String[] tokens) {
        return new Topping(tokens[0] , Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]) , Integer.parseInt(tokens[3]));

    }

    @Override
    String getKey(String[] tokens) {
        return tokens[0];
    }
}
