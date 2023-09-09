package com.app.speficication;

import com.app.entity.Blog;
import com.app.entity.Blog_Reaction;
import com.app.payload.request.BlogInterationQueryParam;
import com.app.payload.request.BlogQueryParam;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.text.Normalizer;

@Component
public class BlogSpecification {
    public Specification<Blog> hasNameLike(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("title"), "%" + keyword + "%");
    }
    public Specification<Blog_Reaction> hasNameLikes(Integer keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("id"), "%" + keyword + "%");
    }


    public Specification<Blog> getBlogSpecification(BlogQueryParam blogQueryParam) {
        Specification<Blog> spec = Specification.where(null);
        if (blogQueryParam.getTitle() != null) {
            spec = spec.and(hasNameLike(blogQueryParam.getTitle()));
        }
        if (blogQueryParam.getTitle() != null) {
            spec = spec.and(hasNameLikeBlog(blogQueryParam.getTitle()));
        }
        return spec;
    }
    public Specification<Blog_Reaction> getBlogInteractionSpecification(BlogInterationQueryParam blogInterationQueryParam) {
        Specification<Blog_Reaction> spec = Specification.where(null);
        if (blogInterationQueryParam.getId() != null) {
            spec = spec.and(hasNameLikes(blogInterationQueryParam.getId()));
        }
        return spec;
    }
    public Specification<Blog> hasNameLikeBlog(String name) {
        return (Root<Blog> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            String nameWithoutDiacritics = removeDiacritics(name);
            String nameUpperCase = nameWithoutDiacritics.toUpperCase();
            Predicate likePredicate = criteriaBuilder.like(
                    criteriaBuilder.upper(root.get("title")),
                    "%" + nameUpperCase + "%"
            );
            return likePredicate;
        };
    }
    private String removeDiacritics(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }


}
