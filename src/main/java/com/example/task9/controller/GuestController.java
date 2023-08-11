package com.example.task9.controller;

import com.example.task9.entity.Guest;
import com.example.task9.controller.response.GuestResponse;
import com.example.task9.service.GuestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GuestController {

    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/guests")
    public List<GuestResponse> guests() {
        List<Guest> guests = guestService.findAll();
        List<GuestResponse> guestResponses = guests.stream().map(guest -> new GuestResponse(guest.getId(), guest.getName(), guest.getAge())).toList();
        return guestResponses;
    }

    //id検索, addressも取得
//    @GetMapping("/guests/{id}")
//    public Optional<Guest> findGuestById(@PathVariable("id") int id){
//        return guestService.findGuestById(id);
//    }

    @GetMapping("/guests/{id}")
    public Optional<GuestResponse> findGuestById (@PathVariable("id") int id){
         return guestService.findGuestById(id);
    }
}



