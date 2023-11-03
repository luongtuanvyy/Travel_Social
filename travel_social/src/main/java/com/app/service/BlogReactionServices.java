package com.app.service;

import com.app.entity.Blog;
import com.app.entity.BlogReaction;
import com.app.payload.request.BlogInterationQueryParam;
import com.app.payload.request.BlogQueryParam;
import com.app.payload.request.BlogReactionQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface BlogReactionServices {

    APIResponse filterBlogReaction(BlogReactionQueryParam blogReactionQueryParam);

    APIResponse create(BlogReaction blogReaction);
    APIResponse update(BlogReaction blogReaction);
    APIResponse delete(Integer id);


}
