package com.app.service.serviceImpl;

import com.app.entity.BookingCancel;
import com.app.entity.TourCancel;
import com.app.payload.request.BookingCancelQueryParam;
import com.app.payload.request.TourCancelQueryParam;
import com.app.payload.response.APIResponse;
import com.app.payload.response.FailureAPIResponse;
import com.app.payload.response.SuccessAPIResponse;
import com.app.repository.BookingCancelRepository;
import com.app.repository.TourCancelRepository;
import com.app.service.BookingCancelServices;
import com.app.service.TourCancelServices;
import com.app.speficication.BookingCancelSpecification;
import com.app.speficication.TourCancelSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class TourCancelServiceimpl implements TourCancelServices {
    @Autowired
    TourCancelSpecification tourCancelSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    TourCancelRepository tourCancelRepository;
    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public APIResponse filterTourCancel(TourCancelQueryParam tourCancelQueryParam) {
        Specification<TourCancel> spec = tourCancelSpecification.getTourCanceSpecitification(tourCancelQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(tourCancelQueryParam);
        Page<TourCancel> response = tourCancelRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
    @Override
    public APIResponse create(TourCancel tourCancel) {
        tourCancel = tourCancelRepository.save(tourCancel);
        return new SuccessAPIResponse(tourCancel);
    }

    @Override
    public APIResponse update(TourCancel tourCancel) {
        if(tourCancel == null){
            return  new FailureAPIResponse("TourCancel id is required!");
        }
        TourCancel exists = tourCancelRepository.findById(tourCancel.getId()).orElse(null);
        if(exists == null){
            return  new FailureAPIResponse("Cannot find TourCancel with id: "+tourCancel.getId());
        }
        tourCancel = tourCancelRepository.save(tourCancel);
        return new SuccessAPIResponse(tourCancel);
    }


    @Override
    public APIResponse delete(Integer id) {
        try {
            tourCancelRepository.deleteById(id);
            return new SuccessAPIResponse("Delete successfully!");
        } catch (Exception ex) {
            return new FailureAPIResponse(ex.getMessage());
        }
    }
}
