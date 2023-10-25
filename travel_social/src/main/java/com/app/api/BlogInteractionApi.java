package com.app.api;

import com.app.payload.request.BlogInterationQueryParam;
import com.app.service.BlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class BlogInteractionApi {
    @Autowired
    BlogServices blogServices;
    @GetMapping("/bloginteractions")
    public ResponseEntity<?> getAllBlogInteraction (BlogInterationQueryParam blogInterationQueryParam) {
        return ResponseEntity.ok(blogServices.filterBlogInteraction(blogInterationQueryParam));
    }
}
