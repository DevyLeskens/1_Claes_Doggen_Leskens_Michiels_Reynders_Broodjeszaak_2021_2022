package model;

import java.util.Observer;


public interface Subject {

    public void registerObserver(OrderEvent orderevent, Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers(int count);

}
