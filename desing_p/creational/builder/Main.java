package com.practice.desing_p.creational.builder;

public class Main {

    public static void main(String[] args) {
        User user = new User.UserBuilder("Deepak", "V")
                        .setCity("Bangalore")//.setCompany("OLA")
                        .build();
        System.out.println(user);
    }
}
