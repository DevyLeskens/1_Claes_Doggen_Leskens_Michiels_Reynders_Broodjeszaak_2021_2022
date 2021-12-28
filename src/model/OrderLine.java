package model;

import model.domain.Sandwich;
import model.domain.Topping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TooManyListenersException;

public class OrderLine {
    private double price;
    private String sandwichname;
    private String toppingnames = "";
    private Sandwich sandwich;
    private ArrayList<Topping> toppingssort = new ArrayList<>();

    public OrderLine(Sandwich sandwich){
        setSandwich(sandwich);
        setSandwichname(sandwich.getName());
    }
    public double getPrice(){
        double total = sandwich.getPrice();
        for (Topping topping: toppingssort) { total += topping.getPrice(); }
        return total;
    }
    public String getSandwichname() {
        return sandwichname;
    }

    public HashMap<String, Integer> getToppingsAsStringMap(){
        HashMap<String, Integer> topping = new HashMap<>();
        for (Topping toppingsort: getToppingssort()) {
            if (topping.containsKey(toppingsort.toString())) {
                topping.put(toppingsort.toString(), topping.get(toppingsort.toString()) + 1);
            } else {
                topping.put(toppingsort.toString(), 1);
            }
        }
        return topping;
    }

    public void setSandwichname(String sandwichname) {
        this.sandwichname = sandwichname;
    }

    public String getToppingnames() {
        return toppingnames;
    }

    public void setToppingnames(ArrayList<String> toppingnames) {
        this.toppingnames = toppingnames.toString();
    }

    public void addTopping(Topping topping) {
        toppingnames +=  topping.getName() + ", ";
        this.toppingssort.add(topping);
        this.toppingnames = toppingnames.replaceFirst(" ", ",");
        this.toppingnames = toppingnames.substring(0,toppingnames.length()-2) + " ";
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public ArrayList<Topping> getToppingssort() {
        return toppingssort;
    }

    public void setToppingssort(ArrayList<Topping> toppingssort) {
        this.toppingssort = toppingssort;
    }

    @Override
    public String toString() {
        return sandwichname + ": " + getToppingsAsStringMap() ;
    }
}
