package com.app.service;

import com.app.payload.request.BookingNotificationQueryParam;
import com.app.payload.response.APIResponse;

public interface BookingNotificationServices {
    APIResponse filterBookingNotification(BookingNotificationQueryParam bookingNotificationQueryParam);
}
