package com.app.repository;

import com.app.entity.Blog_Reaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogInteractionResponsitory extends JpaRepository<Blog_Reaction, Integer> {

    Page<Blog_Reaction> findAll(Specification<Blog_Reaction> spec, Pageable pageable);
}
