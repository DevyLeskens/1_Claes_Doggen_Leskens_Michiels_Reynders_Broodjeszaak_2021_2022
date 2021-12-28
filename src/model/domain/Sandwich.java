package model.domain;

import model.database.SandwichDatabase;

import java.sql.Savepoint;
import java.util.ArrayList;

public class Sandwich extends Product {



    public Sandwich(String name, double price, int stock, int sold) {
        super(name, price, stock, sold);

    }
    @Override
    public Sandwich clone()  {
        return new Sandwich(name, price, stock, sold);
    }



}
