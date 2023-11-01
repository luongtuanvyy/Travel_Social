package com.app.api;

import com.app.payload.request.BlogReactionQueryParam;
import com.app.service.BlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BlogReactionApi {
    @Autowired
    BlogServices blogServices;
    @GetMapping("/blogreaction")
    public ResponseEntity<?> getAllBlogInteraction (BlogReactionQueryParam blogInterationQueryParam) {
        return ResponseEntity.ok(blogServices.filterBlogInteraction(blogInterationQueryParam));
    }
}
