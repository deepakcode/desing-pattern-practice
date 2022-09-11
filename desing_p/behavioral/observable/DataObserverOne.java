package com.practice.desing_p.behavioral.observable;

public class DataObserverOne implements Observer{

    // this data is updated by Subject
    int data;

    @Override
    public void update(int data) {
        this.data=data;
        display();
    }

    @Override
    public void display() {
        System.out.println("Data from One : "+data);
    }

    // this data is updated by Subject ony if you subcribe like below
    private Subject observable;

    public DataObserverOne(Subject observable) {
        this.observable = observable;
    }

    public void register(){
        observable.registerObserver(this);
    }


}
