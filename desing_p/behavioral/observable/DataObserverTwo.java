package com.practice.desing_p.behavioral.observable;

public class DataObserverTwo implements Observer{

    private Subject observable;

    public DataObserverTwo(Subject observable) {
        this.observable = observable;
    }

    int data;

    @Override
    public void update(int data) {
        this.data=data;
        display();
    }

    @Override
    public void display() {
        System.out.println("Data from Two -  : "+data);
    }

    public void register(){
        observable.registerObserver(this);
    }
    
}
