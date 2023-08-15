package com.example.task9.service;

import com.example.task9.exception.ResourceNotFoundException;
import com.example.task9.entity.Guest;
import com.example.task9.controller.response.GuestResponse;
import com.example.task9.mapper.GuestMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {
    private GuestMapper guestMapper;

    public GuestServiceImpl(GuestMapper guestMapper) {
        this.guestMapper = guestMapper;
    }

    @Override
    public List<Guest> findAll() {
        return guestMapper.findAll();
    }

    @Override
    public GuestResponse findGuestById(int id) {
        Optional<GuestResponse> guestResponse = guestMapper.findGuestById(id);
        return guestResponse.orElseThrow(() -> new ResourceNotFoundException("resource not found: " + id));
    }
}
