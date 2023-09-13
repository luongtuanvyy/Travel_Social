package com.app.service.serviceImpl;

import com.app.entity.TourGuide;
import com.app.entity.Vehical;
import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.request.TourPriceQueryParam;
import com.app.payload.request.VehicalQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.TuorGuideRepository;
import com.app.repository.VehicalRepository;
import com.app.service.TourGuideServices;
import com.app.service.TourPriceServices;
import com.app.speficication.TourGuideSpecification;
import com.app.speficication.VehicalSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public class TourGuideServicesImpl implements TourGuideServices {
    @Autowired
    TuorGuideRepository tuorGuideRepository;
    @Autowired
    TourGuideSpecification tourGuideSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;

    @Override
    public APIResponse filterTourGuide(TourGuideQueryParam tourGuideQueryParam) {
        Specification<TourGuide> spec = tourGuideSpecification.getTourGuideSpecification(tourGuideQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(tourGuideQueryParam);
        Page<TourGuide> response = tuorGuideRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
}
