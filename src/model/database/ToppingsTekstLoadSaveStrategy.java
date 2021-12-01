package model.database;

import model.domain.Topping;

public class ToppingsTekstLoadSaveStrategy extends TekstLoadSaveTemplate<String, Topping> {
    @Override
    Topping maakObject(String[] tokens) {
        return new Topping(tokens[0] , Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]) , Integer.parseInt(tokens[3]));

    }

    @Override
    String getKey(String[] tokens) {
        return tokens[0];
    }
}
