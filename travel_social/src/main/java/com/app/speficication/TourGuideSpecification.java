package com.app.speficication;

import com.app.entity.TourGuide;
import com.app.entity.View;
import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.request.ViewQueryParam;
import org.springframework.data.jpa.domain.Specification;

public class TourGuideSpecification {
    public Specification<TourGuide> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public Specification<TourGuide> getTourGuideSpecification(TourGuideQueryParam tourGuideQueryParam) {
        Specification<TourGuide> spec = Specification.where(null);
        if (tourGuideQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(tourGuideQueryParam.getId()));
        }

        return spec;
    }
}
