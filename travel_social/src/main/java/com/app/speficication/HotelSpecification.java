package com.app.speficication;

import com.app.entity.Hotel;
import com.app.payload.request.HotelQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class HotelSpecification {
    public Specification<Hotel> hasIdEqual(Integer id) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public Specification<Hotel> getHotelSpecification(HotelQueryParam hotelQueryParam) {
        Specification<Hotel> spec = Specification.where(null);
        if (hotelQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(hotelQueryParam.getId()));
        }

        return spec;
    }
}
