package com.app.speficication;

import com.app.entity.Favorite;
import com.app.payload.request.FavoriteQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FovoriteSpecification {
    public Specification<Favorite> hasNameLike(LocalDateTime favorite_time) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("favorite_time"), favorite_time);
    }
    public Specification<Favorite> hasNameLikes(Integer keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("id"), "%" + keyword + "%");
    }


    public Specification<Favorite> getFavoriteSpecitification(FavoriteQueryParam favoriteQueryParam) {
        Specification<Favorite> spec = Specification.where(null);
        if (favoriteQueryParam.getFavorite_time() != null) {
            spec = spec.and(hasNameLike(favoriteQueryParam.getFavorite_time()));
        }
        if (favoriteQueryParam.getId() != null) {
            spec = spec.and(hasNameLikes(favoriteQueryParam.getId()));
        }
        return spec;
    }
}
