package model;

import controller.Observer;


public interface Subject {

    public void registerObserver(OrderEvent orderevent, Observer o);

    public void removeObserver(OrderEvent orderEvent, Observer o);

    public void notifyObservers(OrderEvent orderEvent);

}
