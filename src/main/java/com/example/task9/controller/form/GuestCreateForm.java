package com.example.task9.controller.form;

import com.example.task9.entity.Guest;

public class GuestCreateForm {
    public Guest convertToGuest(){
        Guest guest = new Guest(id, name, age, address);
        return guest;
    }
    private int id;
    private String name;
    private int age;
    private String address;

    public int getId() {
        return id;
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
