package model.database;

import java.util.ArrayList;

public class SandwishDatabase {
    public String name;
    public double price;
    public int stock;
    public int sold;
    public ArrayList<SandwishDatabase> sandwishes;


    public SandwishDatabase(String name, double price, int stock, int sold){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sold = sold;
    }

    private void addSandwish(SandwishDatabase sandwish){
        sandwishes.add(sandwish);

    }

    private ArrayList<SandwishDatabase> getDatalist(){
        return sandwishes;
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


}
