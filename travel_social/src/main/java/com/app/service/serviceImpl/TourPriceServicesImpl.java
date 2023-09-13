package com.app.service.serviceImpl;

import com.app.entity.TourGuide;
import com.app.entity.TourPrice;
import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.request.TourPriceQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.TourPriceRepository;
import com.app.repository.TuorGuideRepository;
import com.app.service.TourPriceServices;
import com.app.speficication.TourGuideSpecification;
import com.app.speficication.TuorPriceSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public class TourPriceServicesImpl implements TourPriceServices {
    @Autowired
    TourPriceRepository tourPriceRepository;
    @Autowired
    TuorPriceSpecification tourPriceSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Override
    public APIResponse filterTourPrice(TourPriceQueryParam tourPriceQueryParam) {
        Specification<TourPrice> spec = tourPriceSpecification.getSpecification(tourPriceQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(tourPriceQueryParam);
        Page<TourPrice> response = tourPriceRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }


}
