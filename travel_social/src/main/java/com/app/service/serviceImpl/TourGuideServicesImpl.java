package com.app.service.serviceImpl;

import com.app.entity.Hotel;
import com.app.entity.TourGuide;
import com.app.entity.Vehicle;
import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.request.TourPriceQueryParam;
import com.app.payload.request.VehicalQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.CloudinaryResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
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
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TourGuideServicesImpl implements TourGuideServices {
    @Autowired
    TuorGuideRepository tuorGuideRepository;
    @Autowired
    TourGuideSpecification tourGuideSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;

    @Autowired
    CloudinaryService cloudinaryService;

    @Override
    public APIResponse filterTourGuide(TourGuideQueryParam tourGuideQueryParam) {
        Specification<TourGuide> spec = tourGuideSpecification.getTourGuideSpecification(tourGuideQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(tourGuideQueryParam);
        Page<TourGuide> response = tuorGuideRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }

    @Override
    public APIResponse create(TourGuide tourGuide, MultipartFile image) {
        if (image != null) {
            CloudinaryResponse cloudinaryResponse = cloudinaryService.uploadFile(image, "TourGuide");
            tourGuide.setCloudinaryId(cloudinaryResponse.getCloudinaryId());
            tourGuide.setAvatar(cloudinaryResponse.getUrl());
        }
        tourGuide = tuorGuideRepository.save(tourGuide);
        return new SuccessAPIResponse(tourGuide);
    }

    @Override
    public APIResponse update(TourGuide tourGuide, MultipartFile image) {
        if (tourGuide == null) {
            return new FailureAPIResponse("Blog id is required!");
        }
        TourGuide exists = tuorGuideRepository.findById(tourGuide.getId()).orElse(null);
        if (exists == null) {
            return new FailureAPIResponse("Cannot find blog with id: " + tourGuide.getId());
        }
        if (image != null) {
            cloudinaryService.deleteFile(tourGuide.getCloudinaryId());
            CloudinaryResponse cloudinaryResponse = cloudinaryService.uploadFile(image, "TourGuide");
            tourGuide.setCloudinaryId(cloudinaryResponse.getCloudinaryId());
            tourGuide.setAvatar(cloudinaryResponse.getUrl());
        }
        tourGuide = tuorGuideRepository.save(tourGuide);
        return new SuccessAPIResponse(tourGuide);
    }

    @Override
    public APIResponse delete(Integer id) {
        try {
            tuorGuideRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
