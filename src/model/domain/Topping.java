package model.domain;

public class Topping extends Product {


    private int keyCount;
    public Topping(String name, double price, int stock, int sold) {
        super(name,price,stock,sold);
        setKeyCount(1);

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


    @Override
    public Topping clone()  {
        return new Topping(name, price, stock, sold);
    }



}
