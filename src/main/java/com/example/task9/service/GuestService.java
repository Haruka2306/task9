package com.example.task9.service;

import com.example.task9.controller.form.GuestCreateForm;
import com.example.task9.entity.Guest;
import com.example.task9.controller.response.GuestResponse;

import java.util.List;


public interface GuestService {
    List<Guest> findAll();
    GuestResponse findGuestById(int id);
    Guest createGuest(GuestCreateForm guestCreateForm);
}
