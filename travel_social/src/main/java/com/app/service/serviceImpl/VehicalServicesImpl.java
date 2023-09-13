package com.app.service.serviceImpl;

import com.app.entity.Tour;
import com.app.entity.Vehical;
import com.app.payload.request.TourQueryParam;
import com.app.payload.request.VehicalQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.TourRepository;
import com.app.repository.VehicalRepository;
import com.app.service.VehicalServices;
import com.app.speficication.TourSpecification;
import com.app.speficication.VehicalSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class VehicalServicesImpl implements VehicalServices {

    @Autowired
    VehicalRepository vehicalRepository;
    @Autowired
    VehicalSpecification vehicalSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Override

    public APIResponse filterVehical(VehicalQueryParam vehicalQueryParam) {
        Specification<Vehical> spec = vehicalSpecification.getVehicalSpecification(vehicalQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(vehicalQueryParam);
        Page<Vehical> response = vehicalRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
}
