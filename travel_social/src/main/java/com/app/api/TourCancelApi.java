package com.app.api;

import com.app.entity.BookingCancel;
import com.app.entity.TourCancel;
import com.app.payload.request.BookingCancelQueryParam;
import com.app.payload.request.TourCancelQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.BookingCancelServices;
import com.app.service.TourCancelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class TourCancelApi {
    @Autowired
    TourCancelServices tourCancelServices;

    @GetMapping("/tour_cancel")
    public ResponseEntity<?> filterBookingCancel(TourCancelQueryParam tourCancelQueryParam) {
        return ResponseEntity.ok(tourCancelServices.filterTourCancel(tourCancelQueryParam));
    }

    @PostMapping("/tour_cancel")
    public ResponseEntity<?> createBookingCancel(@RequestPart(name = "tour_cancel") TourCancel tour_cancel){
        APIResponse response = tourCancelServices.create(tour_cancel);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/tour_cancel")
    public ResponseEntity<?> updateBookingCancel(@RequestPart(name = "tour_cancel") TourCancel tour_cancel){
        APIResponse response = tourCancelServices.update(tour_cancel);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/tour_cancel")
    public ResponseEntity<?> deleteBookingCancel(@RequestParam("id") Integer id){
        APIResponse response = tourCancelServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
