package model.domain;


public abstract class Product {
    public String name;
    public double price;
    public int stock;
    public int sold;

    public Product(String name, double price, int stock, int sold) {

        setName(name);
        setPrice(price);
        setStock(stock);
        setSold(sold);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty() || name.trim().isEmpty()){throw new DomainException("Name cannot be empty");}
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price < 0){throw new DomainException("Price can not be negative");}
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock < 0){throw new DomainException("Stock can not be negative");}
        this.stock = stock;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        if(sold < 0){throw new DomainException("Sold can not be negative");}
        this.sold = sold;
    }


}