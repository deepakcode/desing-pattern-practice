package com.practice.desing_p.builder;

public class User {

    String fname;  // Mandatory
    String lname;  // Mandatory

    String company;  //Optional
    String city;  //Optional

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", company='" + company + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getCity() {
        return city;
    }

    public String getCompany() {
        return company;
    }

    public User(UserBuilder builder) {
        this.fname = builder.fname;
        this.lname = builder.lname;
        this.city = builder.city;
        this.company = builder.company;
    }

    public static class UserBuilder {

        String fname;  // Mandatory
        String lname;  // Mandatory

        String company;  //Optional
        String city;  //Optional

        public UserBuilder(String fname, String lname) {
            this.fname = fname;
            this.lname = lname;
        }

        public UserBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder setCompany(String company) {
            this.company = company;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }
}
