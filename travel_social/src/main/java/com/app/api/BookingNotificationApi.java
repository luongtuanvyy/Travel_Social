package com.app.api;

import com.app.entity.BookingNotification;
import com.app.payload.request.BookingNotificationQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.BookingNotificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class BookingNotificationApi {
    @Autowired
    BookingNotificationServices bookingNotificationServices;

    @GetMapping("/booking_notification")
    public ResponseEntity<?> filterBookingCancel(BookingNotificationQueryParam bookingNotificationQuery) {
        return ResponseEntity.ok(bookingNotificationServices.filterBookingNotification(bookingNotificationQuery));
    }

    @PostMapping("/booking_notification")
    public ResponseEntity<?> createBooking(@RequestPart(name = "booking_notification") BookingNotification bookingNotification){
        APIResponse response = bookingNotificationServices.create(bookingNotification);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/booking_notification")
    public ResponseEntity<?> updateBooking(@RequestPart(name = "booking_notification") BookingNotification bookingNotification){
        APIResponse response = bookingNotificationServices.update(bookingNotification);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/booking_notification")
    public ResponseEntity<?> deleteBooking(@RequestParam("id") Integer id){
        APIResponse response = bookingNotificationServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
