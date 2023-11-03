package com.app.service.serviceImpl;

import com.app.entity.BookingCancel;
import com.app.entity.PersonBooking;
import com.app.payload.request.PersonBookingQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.PersonBookingRepository;
import com.app.service.PersonBookingServices;
import com.app.speficication.PersonBookingSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class PersonBookingServicesImpl implements PersonBookingServices {
    @Autowired
    PersonBookingRepository personBookingRepository;
    @Autowired
    PersonBookingSpecification personBookingSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public APIResponse filterPersonBooking(PersonBookingQueryParam personBookingQueryParam) {
        Specification<PersonBooking> spec = personBookingSpecification.getPersonBookingSpecification(personBookingQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(personBookingQueryParam);
        Page<PersonBooking> response = personBookingRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
    @Override
    public APIResponse create(PersonBooking personBooking) {
        personBooking = personBookingRepository.save(personBooking);
        return new SuccessAPIResponse(personBooking);
    }

    @Override
    public APIResponse update(PersonBooking personBooking) {
        if(personBooking == null){
            return  new FailureAPIResponse("Booking id is required!");
        }
        PersonBooking exists = personBookingRepository.findById(personBooking.getId()).orElse(null);
        if(exists == null){
            return  new FailureAPIResponse("Cannot find Booking with id: "+personBooking.getId());
        }
        personBooking = personBookingRepository.save(personBooking);
        return new SuccessAPIResponse(personBooking);
    }


    @Override
    public APIResponse delete(Integer id) {
        try {
            personBookingRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }

}
