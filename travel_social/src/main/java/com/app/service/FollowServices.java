package com.app.service;

import com.app.payload.request.FollowQueryParam;
import com.app.payload.response.APIResponse;

public interface FollowServices {
    APIResponse filterFollow(FollowQueryParam followQueryParam);
}
