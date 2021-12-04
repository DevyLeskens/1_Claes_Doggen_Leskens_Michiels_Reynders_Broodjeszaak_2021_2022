package model.database;

import model.domain.Sandwich;

public class SandwichesTekstLoadSave extends TekstLoadTemplate<String, Sandwich> {

    @Override
    Sandwich maakObject(String[] tokens) {
        return new Sandwich(tokens[0] , Double.parseDouble(tokens[1]), Integer.parseInt(tokens[2]) , Integer.parseInt(tokens[3]));
    }

    @Override
    String getKey(String[] tokens) {
        return tokens[0];
    }
}
