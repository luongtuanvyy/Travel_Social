package com.app.service.serviceImpl;

import com.app.entity.BookingCancel;
import com.app.payload.request.BookingCancelQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.BookingCancelRepository;
import com.app.service.BookingCancelServices;
import com.app.speficication.BookingCancelSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class BookingCancelServiceimpl implements BookingCancelServices {
    @Autowired
    BookingCancelSpecification bookingCancelSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    BookingCancelRepository bookingCancelRepository;
    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public APIResponse filterBookingCancel(BookingCancelQueryParam bookingCancelQueryParam) {
        Specification<BookingCancel> spec = bookingCancelSpecification.getBookingCanceSpecitification(bookingCancelQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(bookingCancelQueryParam);
        Page<BookingCancel> response = bookingCancelRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
    @Override
    public APIResponse create(BookingCancel bookingCancel) {
        bookingCancel = bookingCancelRepository.save(bookingCancel);
        return new SuccessAPIResponse(bookingCancel);
    }

    @Override
    public APIResponse update(BookingCancel bookingCancel) {
        if(bookingCancel == null){
            return  new FailureAPIResponse("Booking id is required!");
        }
        BookingCancel exists = bookingCancelRepository.findById(bookingCancel.getId()).orElse(null);
        if(exists == null){
            return  new FailureAPIResponse("Cannot find Booking with id: "+bookingCancel.getId());
        }
        bookingCancel = bookingCancelRepository.save(bookingCancel);
        return new SuccessAPIResponse(bookingCancel);
    }


    @Override
    public APIResponse delete(Integer id) {
        try {
            bookingCancelRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
