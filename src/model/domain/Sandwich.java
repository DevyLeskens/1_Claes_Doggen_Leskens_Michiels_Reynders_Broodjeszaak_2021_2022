package model.domain;

import model.database.SandwichDatabase;

import java.util.ArrayList;

public class Sandwich {
    public String name;
    public double price;
    public int stock;
    public int sold;

    public Sandwich(String name, double price, int stock, int sold){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("name can not be empty");
        }
        this.name = name;
        if(price == 0){
            throw new IllegalArgumentException("name can not be empty");
        }
        this.price = price;
        this.stock = stock;
        this.sold = sold;
    }
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getSold() {
        return sold;
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
