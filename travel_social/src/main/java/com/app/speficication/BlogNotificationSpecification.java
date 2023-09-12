package com.app.speficication;

import com.app.entity.Account;
import com.app.entity.BlogNotification;
import com.app.payload.request.AccountQueryParam;
import com.app.payload.request.BlogNotificationQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BlogNotificationSpecification {

    public Specification<BlogNotification> hasidequal(Integer keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"),keyword);
    }


    public Specification<BlogNotification> getAccountSpecification(BlogNotificationQueryParam blogNotificationQueryParam) {
        Specification<BlogNotification> spec = Specification.where(null);
        if (blogNotificationQueryParam.getId() != null) {
            spec = spec.and(hasidequal(blogNotificationQueryParam.getId()));
        }
        return spec;
    }
}
