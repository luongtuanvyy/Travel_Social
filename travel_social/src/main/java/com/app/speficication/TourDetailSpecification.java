package com.app.speficication;

import com.app.entity.TourDetail;
import com.app.entity.TourGuide;
import com.app.payload.request.TourDetailQueryParam;
import com.app.payload.request.TourGuideQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TourDetailSpecification {
    public Specification<TourDetail> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public Specification<TourDetail> getTourDetailSpecification(TourDetailQueryParam tourDetailQueryParam) {
        Specification<TourDetail> spec = Specification.where(null);
        if (tourDetailQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(tourDetailQueryParam.getId()));
        }
        return spec;
    }
}
