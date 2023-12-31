package com.app.service;


import com.app.entity.Tour;
import com.app.payload.request.TourQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TourServices {
    APIResponse filterTour(TourQueryParam tourQueryParam);
    APIResponse create(Tour tour, MultipartFile image);
    APIResponse update(Tour tour, MultipartFile image);
    APIResponse delete(Integer id);
}

