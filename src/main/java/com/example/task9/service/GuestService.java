package com.example.task9.service;

import com.example.task9.entity.Guest;
import com.example.task9.controller.response.GuestResponse;

import java.util.List;
import java.util.Optional;

public interface GuestService {
    List<Guest> findAll();
    Optional<GuestResponse> findGuestById(int id);
}
