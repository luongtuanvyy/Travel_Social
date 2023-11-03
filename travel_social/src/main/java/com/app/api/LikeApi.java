package com.app.api;

import com.app.entity.BlogReaction;
import com.app.entity.Like;
import com.app.payload.request.BlogReactionQueryParam;
import com.app.payload.request.LikeQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.LikeRepository;
import com.app.service.BlogReactionServices;
import com.app.service.LikeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class LikeApi {
    @Autowired
    LikeServices likeServices;

    @GetMapping("/like")
    public ResponseEntity<?> filterBookingCancel(LikeQueryParam likeQueryParam) {
        return ResponseEntity.ok(likeServices.filterLike(likeQueryParam));
    }

    @PostMapping("/like")
    public ResponseEntity<?> createBookingCancel(@RequestPart(name = "like") Like like){
        APIResponse response = likeServices.create(like);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/like")
    public ResponseEntity<?> updateBookingCancel(@RequestPart(name = "like") Like like){
        APIResponse response = likeServices.update(like);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/like")
    public ResponseEntity<?> deleteBookingCancel(@RequestParam("id") Integer id){
        APIResponse response = likeServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
