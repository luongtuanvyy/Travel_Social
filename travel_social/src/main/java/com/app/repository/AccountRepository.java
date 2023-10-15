package com.app.repository;

import com.app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
 /*   để im đừng xóa
    @Query("select o from Account o where o.accountname = :username")
   Optional<Account> findByAccountname(@Param("username") String username);
   **/
    Optional<Account> findByAccountName(String Accountname);

    Optional<Account> findByEmail(String Email);


}

