package com.app.api;

import com.app.entity.Tour;
import com.app.payload.request.TourQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.TourServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class TourApi {
    @Autowired
    TourServices tourServices;

    @GetMapping("/tours")
    public ResponseEntity<?> filter(TourQueryParam tourQueryParam) {
            return ResponseEntity.ok(tourServices.filterTour(tourQueryParam));
    }

    @PostMapping("/tours")
    public ResponseEntity<?> createTour(@RequestPart(name = "tour") Tour tour,
                                           @RequestPart(name="image") MultipartFile image){
        APIResponse response = tourServices.create(tour, image);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/tours")
    public ResponseEntity<?> updateTour(@RequestPart(name = "tour") Tour tour,
                                           @RequestPart(name="image") MultipartFile image){
        APIResponse response = tourServices.update(tour, image);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/tours")
    public ResponseEntity<?> deleteTour(@RequestParam("id") Integer id){
        APIResponse response = tourServices.delete(id);
        return ResponseEntity.ok().body(response);
    }


}
