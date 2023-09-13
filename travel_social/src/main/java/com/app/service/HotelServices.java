package com.app.service;

import com.app.payload.request.HotelQueryParam;
import com.app.payload.response.APIResponse;

public interface HotelServices {
    APIResponse filterHotel(HotelQueryParam hotelQueryParam);
}
