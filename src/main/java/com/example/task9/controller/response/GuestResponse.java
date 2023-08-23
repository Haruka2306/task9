package com.example.task9.controller.response;

import com.example.task9.entity.Guest;

public class GuestResponse {
    private int id;
    private String name;
    private int age;

    public GuestResponse(Guest guest) {
        this.id = guest.getId();
        this.name = guest.getName();
        this.age = guest.getAge();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
