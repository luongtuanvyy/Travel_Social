package com.app.service;


import com.app.payload.request.CompanyQueryParam;
import com.app.payload.response.APIResponse;

public interface CompanyServices {
    APIResponse filterCompany(CompanyQueryParam companyQueryParam);
}
