package com.myblog.myblog12;

public class Employee {
    private String name;
    private int age;

    private String city;
    //This constructor works as setters

    public Employee(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }
}
