package com.app.repository;

import com.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("select o from Account o where o.user_name = :username")
    Optional<Account> findByUser_name(@Param("username") String username);
}

