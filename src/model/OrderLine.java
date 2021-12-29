package model;

import model.domain.Sandwich;
import model.domain.Topping;

import java.util.*;

public class OrderLine {
    private String sandwichName;
    private Sandwich sandwich;
    private final ArrayList<Topping> toppingsSort = new ArrayList<>();

    public OrderLine(Sandwich sandwich) {
        setSandwich(sandwich);
        setSandwichName(sandwich.getName());
    }

    public OrderLine() {
    }

    public String getSandwichname() {
        return sandwichName;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public ArrayList<Topping> getToppingsSort() {
        return toppingsSort;
    }

    public double getPrice() {
        double total = sandwich.getPrice();
        for (Topping topping : toppingsSort) {
            total += topping.getPrice();
        }
        return total;
    }


    // wordt gebruikt door tabel in Orderview 'filltables'
    public String getToppingnames() {
        StringBuilder string = new StringBuilder(" ");
        this.getToppingsAsStringMap().forEach((key, value) -> string.append(value).append(" x ").append(key).append(", "));
        return string.substring(0, string.length() > 2 ? string.length() - 2 : string.length() - 1);
    }

    public HashMap<String, Integer> getToppingsAsStringMap() {
        HashMap<String, Integer> toppings = new HashMap<>();
        getToppingsSort().forEach( toppingSort -> toppings.put(toppingSort.toString(), toppings.computeIfAbsent(toppingSort.toString(), k -> 0) + 1));
        return  toppings;
    }
    public HashMap<Topping, Integer> getToppingsAsProductMap() {
        HashMap<Topping, Integer> toppings = new HashMap<>();
        getToppingsSort().forEach( toppingSort -> toppings.put(toppingSort, toppings.computeIfAbsent(toppingSort, k -> 0) + 1));
        return  toppings;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }
    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }
    public void addTopping(Topping topping) {
        this.toppingsSort.add(topping);
    }


    @Override
    public String toString() {
        return sandwichName + " : " + (toppingsSort.size() != 0 ? getToppingsAsStringMap().toString().replace("{", "").replace("}", " ") : "Geen toppings");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLine orderLine = (OrderLine) o;
        return Objects.equals(sandwichName, orderLine.sandwichName) && Objects.equals(sandwich, orderLine.sandwich) && Objects.equals(toppingsSort, orderLine.toppingsSort);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sandwichName, sandwich, toppingsSort);
    }
}
