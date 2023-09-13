package com.app.speficication;

import com.app.entity.Restaurant;
import com.app.payload.request.RestaurantQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class RestaurantSpecification {
    public Specification<Restaurant> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public Specification<Restaurant> getRestaurantSpecification(RestaurantQueryParam restaurantQueryParam) {
        Specification<Restaurant> spec = Specification.where(null);
        if (restaurantQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(restaurantQueryParam.getId()));
        }

        return spec;
    }
}
