package com.app.service;

import com.app.entity.Blog;
import com.app.payload.request.BlogInterationQueryParam;
import com.app.payload.request.BlogQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface BlogServices {
    List<Blog> findAll();
    Optional<Blog> findById(Integer id);

    APIResponse filterBlog(BlogQueryParam blogQueryParam);
    APIResponse filterBlogInteraction(BlogInterationQueryParam blogInterationQueryParam);

    APIResponse create(Blog blog,MultipartFile image);
    APIResponse update(Blog blog,MultipartFile image);
    APIResponse delete(Integer id);


    List<Blog> findByTitle(BlogQueryParam blogQueryParam);

}
