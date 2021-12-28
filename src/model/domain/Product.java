package model.domain;


import java.sql.PreparedStatement;
import java.util.Objects;

public abstract class Product {

    public String name;
    public double price;
    public int stock;
    public int sold;
    private int keyCount;

    public Product(String name, double price, int stock, int sold) {
        setKeyCount(1);
        setName(name);
        setPrice(price);
        setStock(stock);
        setSold(sold);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.trim().isEmpty()) {
            throw new DomainException("Name cannot be empty");
        }
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new DomainException("Price can not be negative");
        }
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new DomainException("Stock can not be negative");
        }
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        if (sold < 0) {
            throw new DomainException("Sold can not be negative");
        }
        this.sold = sold;
    }

    public void setKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    public void updateStock() {
        if (stock > 0) {
            stock--;
        } else {
            throw new IllegalArgumentException("There is currently no stock available.");
        }
    }
    public Product  productIncremented(){
        keyCount++;
        return this;
    }

    @Override
    public String toString() {
        return keyCount +  " x " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && stock == product.stock && sold == product.sold && keyCount == product.keyCount && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, stock, sold, keyCount);
    }

}
