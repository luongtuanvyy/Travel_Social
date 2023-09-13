package com.app.api;

import com.app.payload.request.CompanyQueryParam;
import com.app.service.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class CompanyApi {
    @Autowired
    CompanyServices companyServices;

    @GetMapping("/companys/filter")
    public ResponseEntity<?> getAllCompany (CompanyQueryParam companyQueryParam) {
        return ResponseEntity.ok(companyServices.filterCompany(companyQueryParam));
    }
}
