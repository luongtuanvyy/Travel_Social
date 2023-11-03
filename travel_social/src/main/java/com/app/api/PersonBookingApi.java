package com.app.api;

import com.app.entity.Booking;
import com.app.entity.PersonBooking;
import com.app.payload.request.BookingQueryParam;
import com.app.payload.request.PersonBookingQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.PersonBookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class PersonBookingApi {
    @Autowired
    PersonBookingServices personBookingServices;

    @GetMapping("/person_bookings")
    public ResponseEntity<?> filterPersonBooking(PersonBookingQueryParam personBookingQueryParam) {
        return ResponseEntity.ok(personBookingServices.filterPersonBooking(personBookingQueryParam));
    }

    @PostMapping("/person_bookings")
    public ResponseEntity<?> createPersonBooking(@RequestPart(name = "person_bookings") PersonBooking personBooking){
        APIResponse response = personBookingServices.create(personBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/person_bookings")
    public ResponseEntity<?> updatePersonBooking(@RequestPart(name = "person_bookings") PersonBooking personBooking){
        APIResponse response = personBookingServices.update(personBooking);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/person_bookings")
    public ResponseEntity<?> deletePersonBooking(@RequestParam("id") Integer id){
        APIResponse response = personBookingServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
