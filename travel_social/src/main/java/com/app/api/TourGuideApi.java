package com.app.api;

import com.app.entity.Hotel;
import com.app.entity.TourGuide;
import com.app.payload.request.HotelQueryParam;
import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.TourGuideServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin")
public class TourGuideApi {
    @Autowired
    TourGuideServices tourGuideServices;

    @GetMapping("/tourguides/filter")
    public ResponseEntity<?> getAllTourGuide (TourGuideQueryParam hotelQueryParam) {
        return ResponseEntity.ok(tourGuideServices.filterTourGuide(hotelQueryParam));
    }
    @PostMapping("/tourguides")
    public ResponseEntity<?> createTourGuide(@RequestPart(name = "tuorGuide") TourGuide tourGuide,
                                         @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = tourGuideServices.create(tourGuide,image);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/tourguides")
    public ResponseEntity<?> updateTourGuide(@RequestPart(name = "tuorGuide") TourGuide tourGuide,
                                         @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = tourGuideServices.update(tourGuide, image);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/tourguides")
    public ResponseEntity<?> deleteTourGuide(@RequestParam("id") Integer id){
        APIResponse response = tourGuideServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
