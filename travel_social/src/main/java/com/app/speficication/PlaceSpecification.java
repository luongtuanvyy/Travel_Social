package com.app.speficication;

import com.app.entity.Place;
import com.app.payload.request.PlaceQueryParam;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.text.Normalizer;

@Component
public class PlaceSpecification {
    public Specification<Place> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public Specification<Place> hasNameLike(String name) {
        return (Root<Place> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            String nameWithoutDiacritics = removeDiacritics(name);
            String nameUpperCase = nameWithoutDiacritics.toUpperCase();
            Predicate likePredicate = criteriaBuilder.like(
                    criteriaBuilder.upper(root.get("name")),
                    "%" + nameUpperCase + "%"
            );
            return likePredicate;
        };
    }
    public Specification<Place> hasAddressLike(String Address) {
        return (Root<Place> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            String nameWithoutDiacritics = removeDiacritics(Address);
            String nameUpperCase = nameWithoutDiacritics.toUpperCase();
            Predicate likePredicate = criteriaBuilder.like(
                    criteriaBuilder.upper(root.get("address")),
                    "%" + nameUpperCase + "%"
            );
            return likePredicate;
        };
    }
    private String removeDiacritics(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public Specification<Place> getPlaceSpecification(PlaceQueryParam placeQueryParam) {
        Specification<Place> spec = Specification.where(null);
        if (placeQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(placeQueryParam.getId()));
        }
        if (placeQueryParam.getName() != null) {
            spec = spec.and(hasNameLike(placeQueryParam.getName()));
        }
        if (placeQueryParam.getAddress() != null) {
            spec = spec.and(hasAddressLike(placeQueryParam.getAddress()));
        }
        return spec;
    }
}
