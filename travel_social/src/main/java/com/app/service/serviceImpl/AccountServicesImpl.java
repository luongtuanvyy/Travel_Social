package com.app.service.serviceImpl;

import com.app.entity.Account;
import com.app.payload.request.AccountQueryParam;
import com.app.payload.response.APIResponse;
import com.app.repository.AccountRepository;
import com.app.service.AccountServices;
import com.app.speficication.AccountSpecification;
import com.app.utils.PageUtils;
import com.app.utils.RequestParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServicesImpl implements AccountServices {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountSpecification accountSpecification;

    @Autowired
    RequestParamsUtils requestParamsUtils;
    @Autowired
    CloudinaryService cloudinaryService;
    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public APIResponse filterAccount(AccountQueryParam accountQueryParam) {
        Specification<Account> spec = accountSpecification.getAccountSpecification(accountQueryParam);
        Pageable pageable = requestParamsUtils.getPageable(accountQueryParam);
        Page<Account> response = accountRepository.findAll(spec, pageable);
        return new APIResponse(PageUtils.toPageResponse(response));
    }

    @Override
    public Optional<Account> findByAccountName(String AccountName) {
        return accountRepository.findByAccountName(AccountName);
    }

    @Override
    public Optional<Account> findByEmail(String Email) {
        return accountRepository.findByEmail(Email);
    }
}
