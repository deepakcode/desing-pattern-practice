package com.practice.desing_p.behavioral.observable;

import java.util.*;

public class WheatherStation implements Subject{

    int data=0;

    // update this list whenever subcriber subscribe and remove when they want
    List<Observer> observerList = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    // here you are sending upates to all subcriber, this method would be called in 'setData'
    public void notifyObserver() {
        for(Observer observer: observerList){
            observer.update(data);
        }
    }

    //Whenever you set new value of data then you update your subscribers
    public void setData(int data) {
        this.data = data;
        notifyObserver();
    }
}
