package com.app.service;

import com.app.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountServices {
    List<Account> findAll();
    Optional<Account> findById(Integer id);
    Account save (Account account);

}
