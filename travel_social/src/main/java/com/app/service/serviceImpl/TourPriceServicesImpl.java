package com.app.service.serviceImpl;

import com.app.entity.Favorite;
import com.app.entity.TourGuide;
import com.app.entity.TourPrice;
import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.request.TourPriceQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
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
import org.springframework.stereotype.Service;

@Service

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

    @Override
    public APIResponse create(TourPrice tourPrice) {
        tourPrice = tourPriceRepository.save(tourPrice);
        return new SuccessAPIResponse(tourPrice);
    }

    @Override
    public APIResponse update(TourPrice tourPrice) {
        if (tourPrice == null) {
            return new FailureAPIResponse("Blog id is required!");
        }
        TourPrice exists = tourPriceRepository.findById(tourPrice.getId()).orElse(null);
        if (exists == null) {
            return new FailureAPIResponse("Cannot find blog with id: " + tourPrice.getId());
        }

        tourPrice = tourPriceRepository.save(tourPrice);
        return new SuccessAPIResponse(tourPrice);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            tourPriceRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }


}
