package com.app.api;

import com.app.entity.Review;
import com.app.payload.request.ReviewQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.ReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ReviewApi {
    @Autowired
    ReviewServices reviewServices;

    @GetMapping("/reviews")
    public ResponseEntity<?> getAllReview (ReviewQueryParam reviewQueryParam) {
        return ResponseEntity.ok(reviewServices.filterReview(reviewQueryParam));
    }
    @PostMapping("/reviews")
    public ResponseEntity<?> createReview(@RequestPart(name = "review") Review review,
                                        @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = reviewServices.create(review,image);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/reviews")
    public ResponseEntity<?> updatereview(@RequestPart(name = "review") Review review,
                                        @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = reviewServices.update(review, image);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/reviews")
    public ResponseEntity<?> deleteReview(@RequestParam("id") Integer id){
        APIResponse response = reviewServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
