package com.example.task9.controller.form;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class GuestUpdateForm {
    @NotEmpty(message = "Please provide a name")
    private String name;
    @Range(min = 20, max = 120, message = "Please age must be between 20 and 120")
    private int age;
    @NotEmpty(message = "Please provide an address")
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
