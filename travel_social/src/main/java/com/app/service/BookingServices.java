package com.app.service;

import com.app.dto.BookingDto;
import com.app.payload.response.APIResponse;

public interface BookingServices {
    APIResponse bookTour(BookingDto dto);

}
