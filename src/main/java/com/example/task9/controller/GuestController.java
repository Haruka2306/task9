package com.example.task9.controller;

import com.example.task9.controller.form.GuestCreateForm;
import com.example.task9.controller.form.GuestUpdateForm;
import com.example.task9.exception.ResourceNotFoundException;
import com.example.task9.entity.Guest;
import com.example.task9.controller.response.GuestResponse;
import com.example.task9.service.GuestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@RestController
public class GuestController {

    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/guests")
    public List<GuestResponse> guests() {
        List<Guest> guests = guestService.findAll();
        List<GuestResponse> guestResponses = guests.stream().map(guest -> new GuestResponse(guest)).toList();
        return guestResponses;
    }

    @GetMapping("/guests/{id}")
    public GuestResponse findGuestById (@PathVariable("id") int id){
        Guest guest = guestService.findGuestById(id);
        return new GuestResponse(guest);
    }
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity(body, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/guests")
    public ResponseEntity<Map<String, String>> createGuest(@RequestBody GuestCreateForm guestCreateForm, UriComponentsBuilder uriBuilder) {
        Guest guest = guestService.createGuest(guestCreateForm.convertToGuest());
        URI url = uriBuilder
                .path("/guests/" + guest.getId())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "guest successfully created"));
    }

    @PatchMapping("/guests/{id}")
    public ResponseEntity<Map<String, String>> updateGuest(@PathVariable("id") int id, @RequestBody @Validated GuestUpdateForm guestUpdateForm){
        guestService.updateGuest(id, guestUpdateForm.getName(), guestUpdateForm.getAge(), guestUpdateForm.getAddress());
        return ResponseEntity.ok(Map.of("message", "guest successfully updated"));
    }

    @DeleteMapping("/guests/{id}")
    public ResponseEntity<Map<String, String>> deleteGuest(@PathVariable("id") int id){
        guestService.deleteGuest(id);
        return ResponseEntity.ok(Map.of("message", "guest successfully deleted"));
    }
}
