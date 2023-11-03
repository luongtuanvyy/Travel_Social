package com.app.api;

import com.app.entity.BookingCancel;
import com.app.payload.request.BookingCancelQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.BookingCancelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class BookingCancelApi {
    @Autowired
    BookingCancelServices bookingCancelServices;

    @GetMapping("/booking_cancel")
    public ResponseEntity<?> filterBookingCancel(BookingCancelQueryParam bookingCancelQueryParam) {
        return ResponseEntity.ok(bookingCancelServices.filterBookingCancel(bookingCancelQueryParam));
    }

    @PostMapping("/booking_cancel")
    public ResponseEntity<?> createBookingCancel(@RequestPart(name = "booking_cancel") BookingCancel bookingCancel){
        APIResponse response = bookingCancelServices.create(bookingCancel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/booking_cancel")
    public ResponseEntity<?> updateBookingCancel(@RequestPart(name = "booking_cancel") BookingCancel bookingCancel){
        APIResponse response = bookingCancelServices.update(bookingCancel);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/booking_cancel")
    public ResponseEntity<?> deleteBookingCancel(@RequestParam("id") Integer id){
        APIResponse response = bookingCancelServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
