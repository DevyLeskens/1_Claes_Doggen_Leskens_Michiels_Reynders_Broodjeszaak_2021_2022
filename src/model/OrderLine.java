package model;

import model.domain.Sandwich;
import model.domain.Topping;

import java.util.*;

public class OrderLine {
    private String sandwichname;
    private Sandwich sandwich;
    private final ArrayList<Topping> toppingssort = new ArrayList<>();

    public OrderLine(Sandwich sandwich){
        setSandwich(sandwich);
        setSandwichname(sandwich.getName());
    }
    public OrderLine() { }

    public String getSandwichname() {
        return sandwichname;
    }
    public Sandwich getSandwich() {
        return sandwich;
    }
    public ArrayList<Topping> getToppingssort() {
        return toppingssort;
    }
    public double getPrice(){
        double total = sandwich.getPrice();
        for (Topping topping: toppingssort) {total += topping.getPrice(); }
        return total;
    }


    // wordt gebruikt door tabel in Orderview 'filltables'
    public String getToppingnames() {
        StringBuilder string = new StringBuilder(" ");
        this.getToppingsAsStringMap().forEach((key, value) -> string.append(value).append(" x ").append(key).append(", "));
        return string.substring(0, string.length() > 2 ? string.length() - 2:string.length()-1);
    }
    public HashMap<String, Integer> getToppingsAsStringMap(){
        HashMap<String, Integer> toppings = new HashMap<>();
        for (Topping toppingsort: getToppingssort()) {
            toppings.put(toppingsort.toString(), toppings.computeIfAbsent(toppingsort.toString(), k -> 0) + 1);
        }
        return toppings;
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


    @Override
    public String toString() {
        return sandwichname + " : " + (toppingssort.size() != 0 ? getToppingsAsStringMap().toString().replace("{", "").replace("}", " "): "Geen toppings");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(sandwichname, orderLine.sandwichname)  && Objects.equals(sandwich, orderLine.sandwich) && Objects.equals(toppingssort, orderLine.toppingssort);
    }
    @Override
    public int hashCode() {
        return Objects.hash(sandwichname, sandwich, toppingssort);
    }
}
