package com.app.speficication;

import com.app.entity.Booking;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BookingSpecification {
    public Specification<Booking>hasStatusLike(String status){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("STATUS"),"%"+status+"%") );
    }
}
