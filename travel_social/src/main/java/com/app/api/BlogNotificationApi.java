package com.app.api;

import com.app.entity.BlogNotification;
import com.app.entity.Favorite;
import com.app.payload.request.BlogNotificationQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.BlogNotificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BlogNotificationApi {
    @Autowired
    BlogNotificationServices blogNotificationServices;
    @GetMapping("/blognotification/filter")
    public ResponseEntity<?> getAllBlogNotification (BlogNotificationQueryParam blogNotificationQueryParam) {
        return ResponseEntity.ok(blogNotificationServices.filterBlogNotification(blogNotificationQueryParam));
    }
    @PostMapping("/blognotification")
    public ResponseEntity<?> createFavorite(@RequestPart(name = "blogNotification") BlogNotification blogNotification){
        APIResponse response = blogNotificationServices.create(blogNotification);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/blognotification")
    public ResponseEntity<?> updateFavorite(@RequestPart(name = "blogNotification") BlogNotification blogNotification){
        APIResponse response = blogNotificationServices.update(blogNotification);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/blognotification")
    public ResponseEntity<?> deleteFavorite(@RequestParam("id") Integer id){
        APIResponse response = blogNotificationServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
