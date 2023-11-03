package com.app.service;

import com.app.entity.Like;
import com.app.payload.request.LikeQueryParam;
import com.app.payload.response.APIResponse;


public interface LikeServices {
    APIResponse filterLike(LikeQueryParam likeQueryParam);


    APIResponse create(Like like);

    APIResponse update(Like like);

    APIResponse delete(Integer id);
}
