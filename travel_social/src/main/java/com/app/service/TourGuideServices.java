package com.app.service;

import com.app.entity.TourDetail;
import com.app.entity.TourGuide;
import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TourGuideServices {
    APIResponse filterTourGuide(TourGuideQueryParam tourGuideQueryParam);
    APIResponse create(TourGuide tourGuide, MultipartFile image);
    APIResponse update(TourGuide tourGuide, MultipartFile image);
    APIResponse delete(Integer id);
}
