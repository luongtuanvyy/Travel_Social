package com.app.service;

import com.app.payload.request.ViewQueryParam;
import com.app.payload.response.APIResponse;

public interface ViewServices {
    APIResponse filterView(ViewQueryParam viewQueryParam);
}
