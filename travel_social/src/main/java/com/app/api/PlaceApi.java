package com.app.api;

import com.app.entity.Place;
import com.app.payload.request.PlaceQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.PlaceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@CrossOrigin("*")
@RequestMapping("/api")
public class PlaceApi {
    @Autowired
    PlaceServices placeServices;

    @GetMapping("/places")
    public ResponseEntity<?> filter(PlaceQueryParam placeQueryParam) {
        return ResponseEntity.ok(placeServices.filterPlace(placeQueryParam));
    }

    @PostMapping("/places")
    public ResponseEntity<?> createTour(@RequestPart(name = "place") Place place,
                                        @RequestPart(name="image") MultipartFile image){
        APIResponse response = placeServices.create(place, image);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/places")
    public ResponseEntity<?> updateTour(@RequestPart(name = "place") Place place,
                                        @RequestPart(name="image") MultipartFile image){
        APIResponse response = placeServices.update(place, image);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/places")
    public ResponseEntity<?> deleteTour(@RequestParam("id") Integer id){
        APIResponse response = placeServices.delete(id);
        return ResponseEntity.ok().body(response);
    }
}

