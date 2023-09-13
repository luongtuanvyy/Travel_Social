package com.app.service.serviceImpl;


import com.app.entity.BookingNotification;
import com.app.payload.request.BookingNotificationQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.BookingNotificationRepository;
import com.app.service.BookingNotificationServices;
import com.app.service.BookingServices;
import com.app.speficication.BookingNoficationSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class BookingNotificationServicesImpl implements BookingNotificationServices {
    @Autowired
    BookingNotificationRepository bookingNotificationRepository;
    @Autowired
    BookingNoficationSpecification bookingNoficationSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    CloudinaryService cloudinaryService;


    @Override
    public APIResponse filterBookingNotification(BookingNotificationQueryParam bookingNotificationQueryParam) {
        Specification<BookingNotification> spec = bookingNoficationSpecification.getBookingNotificationSpectication(bookingNotificationQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(bookingNotificationQueryParam);
        Page<BookingNotification> response = bookingNotificationRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
}
