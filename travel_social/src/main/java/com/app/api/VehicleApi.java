package com.app.api;

import com.app.entity.Vehicle;
import com.app.payload.request.VehicalQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.VehicleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/admin")
public class VehicleApi {
    @Autowired
    VehicleServices vehicalServices;

    @GetMapping("/vehicles/filter")
    public ResponseEntity<?> filter(VehicalQueryParam vehicalQueryParam) {
        return ResponseEntity.ok(vehicalServices.filterVehicle(vehicalQueryParam));
    }
    @PostMapping("/vehicles")
    public ResponseEntity<?> createHotel(@RequestPart(name = "vehicle") Vehicle vehicle,
                                         @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = vehicalServices.create(vehicle,image);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/vehicles")
    public ResponseEntity<?> updateHotel(@RequestPart(name = "vehicle") Vehicle vehicle,
                                         @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = vehicalServices.update(vehicle, image);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/vehicles")
    public ResponseEntity<?> deleteHotel(@RequestParam("id") Integer id){
        APIResponse response = vehicalServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
