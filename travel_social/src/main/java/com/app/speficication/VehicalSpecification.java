package com.app.speficication;

import com.app.entity.Vehical;
import com.app.entity.View;
import com.app.payload.request.VehicalQueryParam;
import com.app.payload.request.ViewQueryParam;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class VehicalSpecification {

    public Specification<Vehical> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public Specification<Vehical> getVehicalSpecification(VehicalQueryParam vehicalQueryParam) {
        Specification<Vehical> spec = Specification.where(null);
        if (vehicalQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(vehicalQueryParam.getId()));
        }

        return spec;
    }
}
