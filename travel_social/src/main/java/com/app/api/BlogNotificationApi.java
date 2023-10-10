package com.app.api;

import com.app.payload.request.BlogNotificationQueryParam;
import com.app.service.BlogNotificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BlogNotificationApi {
    @Autowired
    BlogNotificationServices blogNotificationServices;
    @GetMapping("/blognotification/fillter")
    public ResponseEntity<?> getAllblock (BlogNotificationQueryParam blogNotificationQueryParam) {
        return ResponseEntity.ok(blogNotificationServices.filterBlogNotification(blogNotificationQueryParam));
    }

}
