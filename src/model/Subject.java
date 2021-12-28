package model;

import controller.Observer;


public interface Subject {

    void registerObserver(OrderEvent orderevent, Observer o);

    void removeObserver(OrderEvent orderEvent, Observer o);

    void notifyObservers(OrderEvent orderEvent);

}
