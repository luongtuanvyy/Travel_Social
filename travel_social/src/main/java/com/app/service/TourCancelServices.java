package com.app.service;

import com.app.entity.TourCancel;
import com.app.payload.request.TourCancelQueryParam;
import com.app.payload.response.APIResponse;

public interface TourCancelServices {

    APIResponse filterTourCancel (TourCancelQueryParam tourCancelQueryParam);
    APIResponse create(TourCancel tourCancel);
    APIResponse update(TourCancel tourCancel);
    APIResponse delete(Integer id);
}
