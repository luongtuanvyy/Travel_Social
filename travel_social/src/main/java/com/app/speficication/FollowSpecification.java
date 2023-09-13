package com.app.speficication;
import com.app.entity.Follow;
import com.app.payload.request.FollowQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FollowSpecification {
    public Specification<Follow> hasNameLike(LocalDateTime followtime) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("followtime"), followtime);
    }
    public Specification<Follow> hasNameLikes(Integer keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("id"), "%" + keyword + "%");
    }


    public Specification<Follow> getFollowSpecitification(FollowQueryParam followQueryParam) {
        Specification<Follow> spec = Specification.where(null);
        if (followQueryParam.getFollowtime() != null) {
            spec = spec.and(hasNameLike(followQueryParam.getFollowtime()));
        }
        if (followQueryParam.getId() != null) {
            spec = spec.and(hasNameLikes(followQueryParam.getId()));
        }
        return spec;
    }
}
