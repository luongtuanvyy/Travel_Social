package com.app.service;

import com.app.payload.request.TourQueryParam;
import com.app.payload.request.VehicalQueryParam;
import com.app.payload.response.APIResponse;

public interface VehicalServices {
    APIResponse filterVehical(VehicalQueryParam vehicalQueryParam);
}
