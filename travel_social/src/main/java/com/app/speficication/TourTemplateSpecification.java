package com.app.speficication;

import com.app.entity.Blog;
import com.app.entity.Tour;
import com.app.entity.TourTemplate;
import com.app.payload.request.BlogQueryParam;
import com.app.payload.request.TourTemplateQueryParam;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.text.Normalizer;

@Component
public class TourTemplateSpecification {
    public Specification<TourTemplate> hasNameTourTemplate(String name) {
        return (Root<TourTemplate> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            String nameWithoutDiacritics = removeDiacritics(name);
            String nameUpperCase = nameWithoutDiacritics.toUpperCase();
            Predicate likePredicate = criteriaBuilder.like(
                    criteriaBuilder.upper(root.get("name")),
                    "%" + nameUpperCase + "%");
            return likePredicate;
        };
    }

    private String removeDiacritics(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
    public Specification<TourTemplate> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }
    public Specification<TourTemplate> getTourTemplateSpecification(TourTemplateQueryParam tourTemplateQueryParam) {
        Specification<TourTemplate> spec = Specification.where(null);
        if (tourTemplateQueryParam.getName() != null) {
            spec = spec.and(hasNameTourTemplate(tourTemplateQueryParam.getName()));
        }if (tourTemplateQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(tourTemplateQueryParam.getId()));
        }

        return spec;
    }
}
