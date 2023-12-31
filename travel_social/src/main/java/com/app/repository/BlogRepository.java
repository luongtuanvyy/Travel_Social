package com.app.repository;

import com.app.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {


//    @EntityGraph("graph.product")
    Page<Blog> findAll(Specification<Blog> spec, Pageable pageable);
}

