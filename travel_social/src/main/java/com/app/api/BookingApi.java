package com.app.api;

import com.app.entity.Booking;
import com.app.payload.request.BookingQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class BookingApi {
    @Autowired
    BookingServices bookingService;

    @GetMapping("/bookings")
    public ResponseEntity<?> filterBooking(BookingQueryParam bookingQueryParam) {
        return ResponseEntity.ok(bookingService.filterBooking(bookingQueryParam));
    }

    @PostMapping("/bookings")
    public ResponseEntity<?> createBooking(@RequestPart(name = "booking") Booking booking){
        APIResponse response = bookingService.create(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/bookings")
    public ResponseEntity<?> updateBooking(@RequestPart(name = "booking") Booking booking){
        APIResponse response = bookingService.update(booking);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/bookings")
    public ResponseEntity<?> deleteBooking(@RequestParam("id") Integer id){
        APIResponse response = bookingService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
