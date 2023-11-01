package com.app.api;

import com.app.entity.Follow;
import com.app.entity.Hotel;
import com.app.payload.request.FollowQueryParam;
import com.app.payload.request.HotelQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.FollowServices;
import com.app.service.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("api")
public class FollowApi {
    @Autowired
    FollowServices followServices;

    @GetMapping("/follows/filter")
    public ResponseEntity<?> getAllFollow (FollowQueryParam followQueryParam) {
        return ResponseEntity.ok(followServices.filterFollow(followQueryParam));
    }
    @PostMapping("/follows")
    public ResponseEntity<?> createFollow(@RequestPart(name = "follow") Follow follow){
        APIResponse response = followServices.create(follow);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/follows")
    public ResponseEntity<?> updateFollow(@RequestPart(name = "follow") Follow follow){
        APIResponse response = followServices.update(follow);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/follows")
    public ResponseEntity<?> deleteFollow(@RequestParam("id") Integer id){
        APIResponse response = followServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
