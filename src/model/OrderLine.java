package model;

import model.domain.Sandwich;
import model.domain.Topping;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderLine {
    private double price;
    private String sandwichName;
    private String toppingNames = "";
    private Sandwich sandwich;
    private ArrayList<Topping> toppingSorts = new ArrayList<>();

    public OrderLine(Sandwich sandwich) {
        setSandwich(sandwich);
        setSandwichName(sandwich.getName());
    }

    public double getPrice() {
        double total = sandwich.getPrice();
        for (Topping topping : toppingSorts) {
            total += topping.getPrice();
        }
        return total;
    }

    public String getSandwichName() {
        return sandwichName;
    }


    public HashMap<String, Integer> getToppingsAsStringMap() {
        HashMap<String, Integer> topping = new HashMap<>();
        for (Topping toppingSort : getToppingSorts()) {
            if (topping.containsKey(toppingSort.toString())) {
                topping.put(toppingSort.toString(), topping.get(toppingSort.toString()) + 1);
            } else {
                topping.put(toppingSort.toString(), 1);
            }
        }
        return topping;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public String getToppingNames() {
        return toppingNames;
    }

    public void setToppingNames(ArrayList<String> toppingNames) {
        this.toppingNames = toppingNames.toString();
    }

    public void addTopping(Topping topping) {
        toppingNames += topping.getName() + ", ";
        this.toppingSorts.add(topping);
        this.toppingNames = toppingNames.replaceFirst(" ", ",");
        this.toppingNames = toppingNames.substring(0, toppingNames.length() - 2) + " ";
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public ArrayList<Topping> getToppingSorts() {
        return toppingSorts;
    }

    public void setToppingSorts(ArrayList<Topping> toppingSorts) {
        this.toppingSorts = toppingSorts;
    }

    @Override
    public String toString() {
        return sandwichName + ": " + getToppingsAsStringMap();
    }
}
