package com.app.repository;

import com.app.entity.Vehicle;
import com.app.entity.View;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicalRepository extends JpaRepository<Vehicle, Integer> {
    Page<Vehicle> findAll(Specification<Vehicle> spec, Pageable pageable);

}
