package com.example.task9.controller.form;

public class GuestUpdateForm {
    private String name;
    private int age;
    private String address;

    public GuestUpdateForm(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
