package com.app.speficication;

import com.app.entity.Users;
import com.app.payload.request.UserQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class UserSpecification {
    public Specification<Users> hasNameLike(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + keyword + "%");
    }

//    public Specification<Users> hasEmailLike(String keyword) {
//        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), "%" + keyword + "%");
//    }


    public Specification<Users> getUserSpecification(UserQueryParam userQueryParam) {
        Specification<Users> spec = Specification.where(null);
        if (userQueryParam.getName() != null) {
            spec = spec.and(hasNameLike(userQueryParam.getName()));
        }
//        if (userQueryParam.getEmail() != null) {
//            spec = spec.and(hasEmailLike(userQueryParam.getEmail()));
//        }
        return spec;
    }
}
