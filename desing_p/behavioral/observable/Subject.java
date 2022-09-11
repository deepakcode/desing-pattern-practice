package com.practice.desing_p.behavioral.observable;

public interface Subject {

    public void registerObserver(Observer observer);
    public void remove(Observer observer);
    public void notifyObserver();

}
