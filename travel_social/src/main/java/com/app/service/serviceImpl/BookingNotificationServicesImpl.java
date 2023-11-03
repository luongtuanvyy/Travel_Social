package com.app.service.serviceImpl;


import com.app.entity.BookingNotification;
import com.app.payload.request.BookingNotificationQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.BookingNotificationRepository;
import com.app.service.BookingNotificationServices;
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

    @Override
    public APIResponse create(BookingNotification bookingNotification) {
        bookingNotification = bookingNotificationRepository.save(bookingNotification);
        return new SuccessAPIResponse(bookingNotification);
    }

    @Override
    public APIResponse update(BookingNotification bookingNotification) {
        if(bookingNotification == null){
            return  new FailureAPIResponse("Booking id is required!");
        }
        BookingNotification exists = bookingNotificationRepository.findById(bookingNotification.getId()).orElse(null);
        if(exists == null){
            return  new FailureAPIResponse("Cannot find Booking with id: "+bookingNotification.getId());
        }
        bookingNotification = bookingNotificationRepository.save(bookingNotification);
        return new SuccessAPIResponse(bookingNotification);
    }


    @Override
    public APIResponse delete(Integer id) {
        try {
            bookingNotificationRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
