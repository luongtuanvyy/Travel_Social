package com.app.service;

import com.app.payload.request.PersonBookingQueryParam;
import com.app.payload.response.APIResponse;

public interface PersonBookingServices {
    APIResponse filterPersonBooking(PersonBookingQueryParam personBookingQueryParam);
}
