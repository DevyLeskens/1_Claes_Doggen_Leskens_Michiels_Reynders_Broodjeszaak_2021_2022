package model.domain;

public class Topping {

    String name;
    double price;
    int stock;
    int sold;

    public Topping(String name, double price, int stock, int sold) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.sold = sold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }
}
