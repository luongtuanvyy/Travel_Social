package com.app.api;

import com.app.entity.Blog;
import com.app.payload.request.BlogQueryParam;
import com.app.payload.response.APIResponse;
import com.app.service.BlogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class BlogApi {
    @Autowired
    BlogServices blogServices;

    @GetMapping("/blogs/filter")
    public ResponseEntity<?> getAllBlog (BlogQueryParam blogQueryParam) {
        return ResponseEntity.ok(blogServices.filterBlog(blogQueryParam));
    }
    @PostMapping("/blogs")
    public ResponseEntity<?> createBlog(@RequestPart(name = "blog") Blog blog,
                                           @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = blogServices.create(blog,image);
        return ResponseEntity.ok().body(response);
    }
    @PutMapping("/blogs")
    public ResponseEntity<?> updateBlog(@RequestPart(name = "blog") Blog blog,
                                           @RequestPart(name="image") @Nullable MultipartFile image){
        APIResponse response = blogServices.update(blog, image);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/blogs")
    public ResponseEntity<?> deleteBlog(@RequestParam("id") Integer id){
        APIResponse response = blogServices.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
