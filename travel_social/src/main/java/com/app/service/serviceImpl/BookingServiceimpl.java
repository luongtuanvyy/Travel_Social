package com.app.service.serviceImpl;

import com.app.entity.Booking;
import com.app.payload.request.BookingQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.BookingRepository;
import com.app.service.BookingServices;
import com.app.speficication.BookingSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceimpl implements BookingServices {
    @Autowired
    BookingSpecification bookingSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    CloudinaryService cloudinaryService;

    @Override
    public APIResponse filterBooking(BookingQueryParam bookingQueryParam) {
        Specification<Booking> spec = bookingSpecification.getBookingSpecitification(bookingQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(bookingQueryParam);
        Page<Booking> response = bookingRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
    @Override
    public APIResponse create(Booking booking) {
        booking = bookingRepository.save(booking);
        return new SuccessAPIResponse(booking);
    }

    @Override
    public APIResponse update(Booking booking) {
        if(booking == null){
            return  new FailureAPIResponse("Booking id is required!");
        }
        Booking exists = bookingRepository.findById(booking.getId()).orElse(null);
        if(exists == null){
            return  new FailureAPIResponse("Cannot find Booking with id: "+booking.getId());
        }
        booking = bookingRepository.save(booking);
        return new SuccessAPIResponse(booking);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            bookingRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
