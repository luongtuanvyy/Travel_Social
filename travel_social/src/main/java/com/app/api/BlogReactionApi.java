package com.app.api;

import com.app.entity.BlogReaction;
import com.app.entity.BookingCancel;
import com.app.payload.request.BlogReactionQueryParam;
import com.app.payload.request.BookingCancelQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.BlogReactionServices;
import com.app.service.BookingCancelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class BlogReactionApi {
    @Autowired
    BlogReactionServices blogReactionServices;

    @GetMapping("/blog_reaction")
    public ResponseEntity<?> filterBookingCancel(BlogReactionQueryParam blogReactionQueryParam) {
        return ResponseEntity.ok(blogReactionServices.filterBlogReaction(blogReactionQueryParam));
    }

    @PostMapping("/blog_reaction")
    public ResponseEntity<?> createBookingCancel(@RequestPart(name = "blog_reaction") BlogReaction blogReaction){
        APIResponse response = blogReactionServices.create(blogReaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/blog_reaction")
    public ResponseEntity<?> updateBookingCancel(@RequestPart(name = "blog_reaction") BlogReaction blogReaction){
        APIResponse response = blogReactionServices.update(blogReaction);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/blog_reaction")
    public ResponseEntity<?> deleteBookingCancel(@RequestParam("id") Integer id){
        APIResponse response = blogReactionServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
