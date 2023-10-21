package com.app.service;

import com.app.entity.Account;
import com.app.payload.request.AccountQueryParam;
import com.app.payload.response.APIResponse;

import java.util.List;
import java.util.Optional;

public interface AccountServices {
    List<Account> findAll();
    Optional<Account> findById(Integer id);
    Account save (Account account);
    APIResponse filterAccount(AccountQueryParam accountQueryParam);

    Optional<Account> findByAccountName(String AccountName);
    Optional<Account> findByEmail(String Email);
}
