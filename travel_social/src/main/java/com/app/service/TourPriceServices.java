package com.app.service;

import com.app.payload.request.TourPriceQueryParam;
import com.app.payload.response.APIResponse;

public interface TourPriceServices {
    APIResponse filterTourPrice(TourPriceQueryParam tourPriceQueryParam);
}
