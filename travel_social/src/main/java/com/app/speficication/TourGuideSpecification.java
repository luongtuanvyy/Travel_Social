package com.app.speficication;

import com.app.entity.Hotel;
import com.app.entity.TourGuide;
import com.app.entity.View;
import com.app.payload.request.TourGuideQueryParam;
import com.app.payload.request.ViewQueryParam;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.text.Normalizer;
@Component
public class TourGuideSpecification {
    public Specification<TourGuide> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }
    public Specification<TourGuide> hasNameLike(String name) {
        return (Root<TourGuide> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            String nameWithoutDiacritics = removeDiacritics(name);
            String nameUpperCase = nameWithoutDiacritics.toUpperCase();
            Predicate likePredicate = criteriaBuilder.like(
                    criteriaBuilder.upper(root.get("name")),
                    "%" + nameUpperCase + "%"
            );
            return likePredicate;
        };
    }

    private String removeDiacritics(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public Specification<TourGuide> getTourGuideSpecification(TourGuideQueryParam tourGuideQueryParam) {
        Specification<TourGuide> spec = Specification.where(null);
        if (tourGuideQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(tourGuideQueryParam.getId()));
        }
        if (tourGuideQueryParam.getName() != null) {
            spec = spec.and(hasNameLike(tourGuideQueryParam.getName()));
        }

        return spec;
    }
}
