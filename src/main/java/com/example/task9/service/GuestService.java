package com.example.task9.service;

import com.example.task9.entity.Guest;

import java.util.List;


public interface GuestService {
    List<Guest> findAll();
    Guest findGuestById(int id);
    Guest createGuest(Guest guest);
    void updateGuest(int id, String name, int age, String address);
}
