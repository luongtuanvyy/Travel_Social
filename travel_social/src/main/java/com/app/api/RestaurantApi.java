package com.app.api;

import com.app.entity.Hotel;
import com.app.entity.Restaurant;
import com.app.payload.request.HotelQueryParam;
import com.app.payload.request.RestaurantQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.RestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/admin")
public class RestaurantApi {
    @Autowired
    RestaurantServices restaurantServices;

    @GetMapping("/restaurants/filter")
    public ResponseEntity<?> getAllRestaurant (RestaurantQueryParam restaurantQueryParam) {
        return ResponseEntity.ok(restaurantServices.filterRestaurant(restaurantQueryParam));
    }
    @PostMapping("/restaurants")
    public ResponseEntity<?> createRestaurant(@RequestPart(name = "restaurant") Restaurant restaurant,
                                         @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = restaurantServices.create(restaurant,image);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/restaurants")
    public ResponseEntity<?> updateRestaurant(@RequestPart(name = "restaurant") Restaurant restaurant,
                                         @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = restaurantServices.update(restaurant, image);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/restaurants")
    public ResponseEntity<?> deleteRestaurant(@RequestParam("id") Integer id){
        APIResponse response = restaurantServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
