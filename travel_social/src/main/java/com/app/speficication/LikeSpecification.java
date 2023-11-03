package com.app.speficication;

import com.app.entity.Like;
import com.app.entity.Payment;
import com.app.payload.request.LikeQueryParam;
import com.app.payload.request.PaymentQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class LikeSpecification {

    public Specification<Like> hasIdEqual(Integer id){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"),id) );
    }
    public Specification<Like> getLikeSpecitification(LikeQueryParam likeQueryParam) {
        Specification<Like> spec = Specification.where(null);
        if (likeQueryParam.getId() != null) {
            spec = spec.and(hasIdEqual(likeQueryParam.getId()));
        }
        return spec;
    }
}
