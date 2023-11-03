package com.app.service;

import com.app.entity.View;
import com.app.payload.request.ViewQueryParam;
import com.app.payload.response.APIResponse;

public interface ViewServices {
    APIResponse filterView(ViewQueryParam viewQueryParam);


    APIResponse create(View view);

    APIResponse update(View view);

    APIResponse delete(Integer id);
}
