package model;

import model.domain.Sandwich;
import model.domain.Topping;
import model.vanillaplusfunctions.DefaultIntDict;

import java.util.*;

public class OrderLine {
    private String sandwichname;
    private String toppingnames = "";
    private Sandwich sandwich;
    private ArrayList<Topping> toppingssort = new ArrayList<>();

    public OrderLine(Sandwich sandwich){
        setSandwich(sandwich);
        setSandwichname(sandwich.getName());
    }
    public Sandwich getSandwich() {
        return sandwich;
    }
    public ArrayList<Topping> getToppingssort() {
        return toppingssort;
    }
    public double getPrice(){
        double total = sandwich.getPrice();
        for (Topping topping: toppingssort) { total += topping.getPrice(); }
        return total;
    }
    public String getSandwichname() {
        return sandwichname;
    }
    public OrderLine(String toppingnames) {
        this.toppingnames = toppingnames;
    }

    public String getToppingnames() {
        StringBuilder string = new StringBuilder(" ");
        this.getToppingsAsStringMap().forEach((key, value) -> string.append(value).append(" x ").append(key).append(", "));
        return string.substring(0, string.length() > 2 ? string.length() - 2:string.length()-1);
    }

    public void setToppingnames(String toppingnames) {
        this.toppingnames = toppingnames;
    }

    public void setSandwichname(String sandwichname) {
        this.sandwichname = sandwichname;
    }
    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public void addTopping(Topping topping) {
        this.toppingssort.add(topping);
    }
    public HashMap<String, Integer> getToppingsAsStringMap(){
        DefaultIntDict<String, Integer> toppings = new DefaultIntDict<>(0);
        for (Topping toppingsort: getToppingssort()) {
            toppings.put(toppingsort.toString(), toppings.safeGet(toppingsort.toString()) + 1);
        }
        return toppings;
    }

    @Override
    public String toString() {
        return sandwichname + " : " + (toppingssort.size() != 0 ? getToppingsAsStringMap().toString().replace("{", "").replace("}", " "): "Geen toppings");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(sandwichname, orderLine.sandwichname) && Objects.equals(toppingnames, orderLine.toppingnames) && Objects.equals(sandwich, orderLine.sandwich) && Objects.equals(toppingssort, orderLine.toppingssort);
    }
    @Override
    public int hashCode() {
        return Objects.hash(sandwichname, toppingnames, sandwich, toppingssort);
    }
}
