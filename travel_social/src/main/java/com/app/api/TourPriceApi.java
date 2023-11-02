package com.app.api;

import com.app.entity.Favorite;
import com.app.entity.TourPrice;
import com.app.payload.request.FavoriteQueryParam;
import com.app.payload.request.TourPriceQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.FavoriteServices;
import com.app.service.TourPriceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class TourPriceApi {
    @Autowired
    TourPriceServices tourPriceServices;

    @GetMapping("/tourprice/filter")
    public ResponseEntity<?> getAllPrice (TourPriceQueryParam tourPriceQueryParam) {
        return ResponseEntity.ok(tourPriceServices.filterTourPrice(tourPriceQueryParam));
    }
    @PostMapping("/tourprice")
    public ResponseEntity<?> createPrice(@RequestPart(name = "tourPrice") TourPrice tourPrice){
        APIResponse response = tourPriceServices.create(tourPrice);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/tourprice")
    public ResponseEntity<?> updatePrice(@RequestPart(name = "tourPrice") TourPrice tourPrice){
        APIResponse response = tourPriceServices.update(tourPrice);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/tourprice")
    public ResponseEntity<?> deletePrice(@RequestParam("id") Integer id){
        APIResponse response = tourPriceServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
