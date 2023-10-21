package com.app.service.serviceImpl;

import com.app.entity.Tour;
import com.app.entity.TourDetail;
import com.app.payload.request.TourDetailQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.CloudinaryResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
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
import org.springframework.web.multipart.MultipartFile;

@Service
public class TourDetailServicesImpl implements TourDetailServices {

    @Autowired
    TourDetailRepository tourDetailRepository;

    @Autowired
    TourDetailSpecification tourDetailSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;

    @Autowired
    CloudinaryService cloudinaryService;

    @Override
    public APIResponse filterTourDetail(TourDetailQueryParam tourDetailQueryParam) {
        Specification<TourDetail> spec = tourDetailSpecification.getTourDetailSpecification(tourDetailQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(tourDetailQueryParam);
        Page<TourDetail> response = tourDetailRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }

    @Override
    public APIResponse create(TourDetail tourDetail) {

        tourDetail = tourDetailRepository.save(tourDetail);
        return new SuccessAPIResponse(tourDetail);
    }

    @Override
    public APIResponse update(TourDetail tourDetail) {
        if(tourDetail == null){
            return  new FailureAPIResponse("tour id is required!");
        }
        TourDetail exists = tourDetailRepository.findById(tourDetail.getId()).orElse(null);
        if(exists == null){
            return  new FailureAPIResponse("Cannot find product with id: "+tourDetail.getId());
        }
        tourDetail = tourDetailRepository.save(tourDetail);
        return new SuccessAPIResponse(tourDetail);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            tourDetailRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}