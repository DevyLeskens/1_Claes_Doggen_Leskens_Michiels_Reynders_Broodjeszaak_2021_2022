package model;

import model.domain.Sandwich;
import model.domain.Topping;

import java.util.ArrayList;

public class OrderLine {
    String sandwichname;
    ArrayList<String> toppingnames;
    Sandwich sandwich;
    ArrayList<Topping> toppingssort;

    public OrderLine(){

    }

    public String getSandwichname() {
        return sandwichname;
    }

    public void setSandwichname(String sandwichname) {
        this.sandwichname = sandwichname;
    }

    public ArrayList<String> getToppingnames() {
        return toppingnames;
    }

    public void setToppingnames(ArrayList<String> toppingnames) {
        this.toppingnames = toppingnames;
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
}