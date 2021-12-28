package model.domain;

public class Topping extends Product {

    public Topping(String name, double price, int stock, int sold) {
        super(name, price, stock, sold);

    }

    @Override
    public String toString() {
        return name;
    }
}
