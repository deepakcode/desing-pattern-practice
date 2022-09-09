package com.practice.desing_p.observable;


import java.util.*;

public class WheatherStation implements Subject{

    int data=0;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
        notifiyObserver();
    }

    List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {

    }

    @Override
    public void notifiyObserver() {

        for(Observer observer: observerList){
            observer.update(data);
        }

    }
}
