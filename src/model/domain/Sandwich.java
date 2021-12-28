package model.domain;

public class Sandwich extends Product {

    public Sandwich(String name, double price, int stock, int sold) {
        super(name, price, stock, sold);

    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", sold=" + sold +
                '}';
    }

}
