package com.app.service;

import com.app.entity.BookingNotification;
import com.app.payload.request.BookingNotificationQueryParam;
import com.app.payload.response.APIResponse;

public interface BookingNotificationServices {
    APIResponse filterBookingNotification(BookingNotificationQueryParam bookingNotificationQueryParam);

    APIResponse create(BookingNotification bookingNotification);

    APIResponse update(BookingNotification bookingNotification);

    APIResponse delete(Integer id);
}
