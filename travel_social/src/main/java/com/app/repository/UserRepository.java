package com.app.repository;

import com.app.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Page<Users> findAll(Specification<Users> spec, Pageable pageable);


    Optional<Users> findById(Integer id);

    Optional<Users> findByEmail(String email);


}
