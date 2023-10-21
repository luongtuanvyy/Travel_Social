package com.app.service;

import com.app.entity.TourDetail;
import com.app.payload.request.TourDetailQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TourDetailServices {
    APIResponse filterTourDetail(TourDetailQueryParam tourDetailQueryParam);

    APIResponse create(TourDetail tourDetail);
    APIResponse update(TourDetail tourDetail);
    APIResponse delete(Integer id);
}
