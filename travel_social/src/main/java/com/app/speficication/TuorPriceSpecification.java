package com.app.speficication;

import com.app.entity.TourPrice;
import com.app.entity.View;
import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.request.TourPriceQueryParam;
import com.app.payload.request.ViewQueryParam;
import org.springframework.data.jpa.domain.Specification;

public class TuorPriceSpecification {

    public Specification<TourPrice> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public Specification<TourPrice> getSpecification(TourPriceQueryParam tuorPriceQueryParam) {
        Specification<TourPrice> spec = Specification.where(null);
        if (tuorPriceQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(tuorPriceQueryParam.getId()));
        }

        return spec;
    }
}
