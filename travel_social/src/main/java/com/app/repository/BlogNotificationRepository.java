package com.app.repository;
import com.app.entity.BlogNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogNotificationRepository extends JpaRepository<BlogNotification, Integer> {
    Page<BlogNotification> findAll(Specification<BlogNotification> spec, Pageable pageable);
}
