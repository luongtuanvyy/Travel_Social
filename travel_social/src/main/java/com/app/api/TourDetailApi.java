package com.app.api;

import com.app.entity.TourDetail;
import com.app.payload.request.TourDetailQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.TourDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class TourDetailApi {
    @Autowired
    TourDetailServices tourDetailServices;
    @GetMapping("/toursdetail")
    public ResponseEntity<?> filter(TourDetailQueryParam tourDetailQueryParam) {
        return ResponseEntity.ok(tourDetailServices.filterTourDetail(tourDetailQueryParam));
    }
    @PostMapping("/company/toursdetail")
    public ResponseEntity<?> createTour(@RequestPart(name = "tour") TourDetail tour){
        APIResponse response = tourDetailServices.create(tour);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/company/toursdetail")
    public ResponseEntity<?> updateTour(@RequestPart(name = "tour") TourDetail tour){
        APIResponse response = tourDetailServices.update(tour);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/company/toursdetail")
    public ResponseEntity<?> deleteTour(@RequestParam("id") Integer id){
        APIResponse response = tourDetailServices.delete(id);
        return ResponseEntity.ok().body(response);
    }

}