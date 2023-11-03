package com.app.service;

import com.app.entity.PersonBooking;
import com.app.payload.request.PersonBookingQueryParam;
import com.app.payload.response.APIResponse;

public interface PersonBookingServices {
    APIResponse filterPersonBooking(PersonBookingQueryParam personBookingQueryParam);


    APIResponse create(PersonBooking personBooking);

    APIResponse update(PersonBooking personBooking);

    APIResponse delete(Integer id);
}
