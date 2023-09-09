package com.app.speficication;


import com.app.entity.Account;
import com.app.payload.request.AccountQueryParam;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AccountSpecification {
    public Specification<Account> hasNameLike(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), "%" + keyword + "%");
    }


    public Specification<Account> getAccountSpecification(AccountQueryParam accountQueryParam) {
        Specification<Account> spec = Specification.where(null);
        if (accountQueryParam.getEmail() != null) {
            spec = spec.and(hasNameLike(accountQueryParam.getEmail()));
        }
        return spec;
    }
}
