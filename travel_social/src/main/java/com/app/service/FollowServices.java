package com.app.service;

import com.app.entity.Follow;
import com.app.entity.Hotel;
import com.app.payload.request.FollowQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

public interface FollowServices {
    APIResponse filterFollow(FollowQueryParam followQueryParam);
    APIResponse create(Follow follow);
    APIResponse update(Follow follow);
    APIResponse delete(Integer id);
}
