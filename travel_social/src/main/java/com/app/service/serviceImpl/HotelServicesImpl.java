package com.app.service.serviceImpl;

import com.app.entity.Hotel;
import com.app.payload.request.HotelQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.HotelRepository;
import com.app.service.HotelServices;
import com.app.speficication.HotelSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class HotelServicesImpl implements HotelServices {
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    HotelSpecification hotelSpecification;
    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public APIResponse filterHotel(HotelQueryParam hotelQueryParam) {
        Specification<Hotel> spec = hotelSpecification.getHotelSpecification(hotelQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(hotelQueryParam);
        Page<Hotel> response = hotelRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
}
