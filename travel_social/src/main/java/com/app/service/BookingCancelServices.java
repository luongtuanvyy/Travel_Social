package com.app.service;

import com.app.entity.BookingCancel;
import com.app.payload.request.BookingCancelQueryParam;
import com.app.payload.request.BookingQueryParam;
import com.app.payload.response.APIResponse;

public interface BookingCancelServices {

    APIResponse filterBookingCancel (BookingCancelQueryParam bookingCancelQueryParam);
    APIResponse create(BookingCancel bookingCancel);
    APIResponse update(BookingCancel bookingCancel);
    APIResponse delete(Integer id);
}
