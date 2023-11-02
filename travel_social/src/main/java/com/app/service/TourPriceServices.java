package com.app.service;

import com.app.entity.Tour;
import com.app.entity.TourPrice;
import com.app.payload.request.TourPriceQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TourPriceServices {
    APIResponse filterTourPrice(TourPriceQueryParam tourPriceQueryParam);
    APIResponse create(TourPrice tourPrice);
    APIResponse update(TourPrice tourPrice);
    APIResponse delete(Integer id);
}
