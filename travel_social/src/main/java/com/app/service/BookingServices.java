package com.app.service;

import com.app.entity.Booking;
import com.app.payload.request.BookingQueryParam;
import com.app.payload.response.APIResponse;

public interface BookingServices {
    APIResponse filterBooking (BookingQueryParam bookingQueryParam);
    APIResponse create(Booking booking);
    APIResponse update(Booking booking);
    APIResponse delete(Integer id);

}
