package com.app.service;

import com.app.entity.Tour;
import com.app.entity.TourTemplate;
import com.app.payload.request.TourQueryParam;
import com.app.payload.request.TourTemplateQueryParam;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TourTemplateServices {
    APIResponse filterTourTemplate(TourTemplateQueryParam tourTemplateQueryParam);

    APIResponse create(TourTemplate tourTemplate);
    APIResponse update(TourTemplate tourTemplate);
    APIResponse delete(Integer id);
}
