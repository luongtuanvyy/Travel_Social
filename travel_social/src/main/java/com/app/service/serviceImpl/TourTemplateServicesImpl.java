package com.app.service.serviceImpl;

import com.app.entity.Tour;
import com.app.entity.TourTemplate;
import com.app.payload.request.TourQueryParam;
import com.app.payload.request.TourTemplateQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.CloudinaryResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.TourRepository;
import com.app.repository.TourTemplateRepository;
import com.app.service.TourServices;
import com.app.service.TourTemplateServices;
import com.app.speficication.TourSpecification;
import com.app.speficication.TourTemplateSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TourTemplateServicesImpl implements TourTemplateServices {
    @Autowired
    TourTemplateRepository tourTemplateRepository;

    @Autowired
    RequestParamsUtils requestParamsUtils;

    @Autowired
    TourTemplateSpecification tourTemplateSpecification;

    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public APIResponse filterTourTemplate(TourTemplateQueryParam tourTemplateQueryParam) {
        Specification<TourTemplate> spec = tourTemplateSpecification.getTourTemplateSpecification(tourTemplateQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(tourTemplateQueryParam);
        Page<TourTemplate> response = tourTemplateRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }

    @Override
    public APIResponse create(TourTemplate tourTemplate) {
        tourTemplate = tourTemplateRepository.save(tourTemplate);
        return new SuccessAPIResponse(tourTemplate);
    }

    @Override
    public APIResponse update(TourTemplate tourTemplate) {
        if(tourTemplate == null){
            return  new FailureAPIResponse("tour id is required!");
        }
        TourTemplate exists = tourTemplateRepository.findById(tourTemplate.getId()).orElse(null);
        if(exists == null){
            return  new FailureAPIResponse("Cannot find product with id: "+tourTemplate.getId());
        }
        tourTemplate = tourTemplateRepository.save(tourTemplate);
        return new SuccessAPIResponse(tourTemplate);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            tourTemplateRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
