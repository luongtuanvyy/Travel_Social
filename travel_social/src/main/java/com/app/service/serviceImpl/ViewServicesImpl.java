package com.app.service.serviceImpl;
import com.app.entity.Vehical;
import com.app.entity.View;
import com.app.payload.request.ViewQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.VehicalRepository;
import com.app.repository.ViewRepository;
import com.app.service.ViewServices;
import com.app.speficication.VehicalSpecification;
import com.app.speficication.ViewSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ViewServicesImpl implements ViewServices {
    @Autowired
    ViewRepository viewRepository;
    @Autowired
    ViewSpecification viewSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Override
    public APIResponse filterView(ViewQueryParam viewQueryParam) {
        Specification<View> spec = viewSpecification.getViewSpecification(viewQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(viewQueryParam);
        Page<View> response = viewRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
}
