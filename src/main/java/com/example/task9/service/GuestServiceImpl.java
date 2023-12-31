package com.example.task9.service;

import com.example.task9.exception.ResourceNotFoundException;
import com.example.task9.entity.Guest;
import com.example.task9.mapper.GuestMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService {
    private final GuestMapper guestMapper;

    public GuestServiceImpl(GuestMapper guestMapper) {
        this.guestMapper = guestMapper;
    }

    @Override
    public List<Guest> findAll() {
        return guestMapper.findAll();
    }

    @Override
    public Guest findGuestById(int id) {
        Optional<Guest> guest = guestMapper.findGuestById(id);
        return guest.orElseThrow(() -> new ResourceNotFoundException("resource not found: " + id));}

    @Override
    public Guest createGuest(Guest guest) {
        guestMapper.insertGuest(guest);
        return guest;
    }

    @Override
    public void updateGuest(int id, String name, int age, String address){
        Guest guest = guestMapper.findGuestById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found: " + id));
        guest.setName(name);
        guest.setAge(age);
        guest.setAddress(address);
        guestMapper.updateGuest(guest);
    }

    @Override
    public void deleteGuest(int id){
        guestMapper.findGuestById(id).orElseThrow(() -> new ResourceNotFoundException("resource not found: " + id));
        guestMapper.deleteGuest(id);
    }
}
