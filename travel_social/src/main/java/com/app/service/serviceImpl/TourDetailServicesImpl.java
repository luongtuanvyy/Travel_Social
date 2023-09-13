package com.app.service.serviceImpl;

import com.app.entity.TourDetail;
import com.app.payload.request.TourDetailQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.TourDetailRepository;
import com.app.service.TourDetailServices;
import com.app.speficication.TourDetailSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TourDetailServicesImpl implements TourDetailServices {

    @Autowired
    TourDetailRepository tourDetailRepository;

    @Autowired
    TourDetailSpecification tourDetailSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;

    @Override
    public APIResponse filterTourDetail(TourDetailQueryParam tourDetailQueryParam) {
        Specification<TourDetail> spec = tourDetailSpecification.getTourDetailSpecification(tourDetailQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(tourDetailQueryParam);
        Page<TourDetail> response = tourDetailRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
}
