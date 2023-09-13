package com.app.service;

import com.app.payload.request.LikeQueryParam;
import com.app.payload.response.APIResponse;


public interface LikeServices {
    APIResponse filterLike(LikeQueryParam likeQueryParam);
}
