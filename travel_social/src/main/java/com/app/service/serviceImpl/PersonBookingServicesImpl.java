package com.app.service.serviceImpl;

import com.app.entity.PersonBooking;
import com.app.payload.request.PersonBookingQueryParam;
import com.app.payload.response.APIResponse;
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
}
