package com.app.speficication;

import com.app.entity.Tour;
import com.app.entity.Vehicle;
import com.app.entity.View;
import com.app.payload.request.VehicalQueryParam;
import com.app.payload.request.ViewQueryParam;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.Normalizer;

@Component
public class VehicalSpecification {

    public Specification<Vehicle> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }
    public Specification<Vehicle> hasNameLike(String name) {
        return (Root<Vehicle> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
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

    public Specification<Vehicle> getVehicalSpecification(VehicalQueryParam vehicalQueryParam) {
        Specification<Vehicle> spec = Specification.where(null);
        if (vehicalQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(vehicalQueryParam.getId()));
        }
        if (vehicalQueryParam.getName() != null) {
            spec = spec.and(hasNameLike(vehicalQueryParam.getName()));
        }

        return spec;
    }
}
