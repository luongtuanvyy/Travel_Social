package com.app.speficication;
import com.app.entity.Follow;
import com.app.payload.request.FollowQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FollowSpecification {
    public Specification<Follow> hasNameLike(Integer followerID) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("followerID"), "%" + followerID + "%");
    }
    public Specification<Follow> hasNameLikes(Integer keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("id"), "%" + keyword + "%");
    }


    public Specification<Follow> getFollowSpecitification(FollowQueryParam followQueryParam) {
        Specification<Follow> spec = Specification.where(null);
        if (followQueryParam.getFollowerID() != null) {
            spec = spec.and(hasNameLike(followQueryParam.getFollowerID()));
        }
        if (followQueryParam.getId() != null) {
            spec = spec.and(hasNameLikes(followQueryParam.getId()));
        }
        return spec;
    }
}
