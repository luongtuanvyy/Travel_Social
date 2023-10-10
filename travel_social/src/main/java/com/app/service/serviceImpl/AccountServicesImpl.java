package com.app.service.serviceImpl;

import com.app.entity.Account;
import com.app.repository.AccountRepository;
import com.app.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServicesImpl implements AccountServices {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }


//    @Override
//    public Optional<Account> findByUsername(String username) {
//        return accountRepository.findByUser_name(username);
//    }

    @Override
    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
