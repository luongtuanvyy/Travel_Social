package com.app.service;

import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.response.APIResponse;

public interface TourGuideServices {
    APIResponse filterTourGuide(TourGuideQueryParam tourGuideQueryParam);
}
