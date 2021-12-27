package model;

import model.domain.Sandwich;
import model.domain.Topping;

import java.util.ArrayList;
import java.util.TooManyListenersException;

public class OrderLine {
    String sandwichname;
    String toppingnames = "";
    Sandwich sandwich;
    ArrayList<Topping> toppingssort;

    public OrderLine(Sandwich sandwich){
        setSandwich(sandwich);
        setSandwichname(sandwich.getName());
    }

    public String getSandwichname() {
        return sandwichname;
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

    public void addTopping(String topping) {
        toppingnames +=  topping + ", ";
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
        return "OrderLine{" +
                "sandwichname='" + sandwichname + '\'' +
                ", toppingnames=" + toppingnames +
                ", sandwich=" + sandwich +
                ", toppingssort=" + toppingssort +
                '}';
    }
}
