package com.app.service.serviceImpl;

import com.app.entity.Company;
import com.app.payload.request.CompanyQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.CompanyRepository;
import com.app.service.CompanyServices;
import com.app.speficication.CompanySpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceslmpl implements CompanyServices {
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    CompanySpecification companySpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;

    @Override
    public APIResponse filterCompany(CompanyQueryParam companyQueryParam) {
        Specification<Company> spec = companySpecification.getCompanySpecification(companyQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(companyQueryParam);
        Page<Company> response = companyRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }
}
