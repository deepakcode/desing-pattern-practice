package com.practice.desing_p.statem;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.handle();
        context.setState(new StateB());
        context.handle();
    }
}
