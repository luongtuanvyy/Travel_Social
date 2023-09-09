package com.app.speficication;

import com.app.entity.Company;
import com.app.payload.request.CompanyQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class CompanySpecification {
    public Specification<Company> hasNameLike(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + keyword + "%");
    }


    public Specification<Company> getCompanySpecification(CompanyQueryParam companyQueryParam) {
        Specification<Company> spec = Specification.where(null);
        if (companyQueryParam.getName() != null) {
            spec = spec.and(hasNameLike(companyQueryParam.getName()));
        }
        return spec;
    }
}
