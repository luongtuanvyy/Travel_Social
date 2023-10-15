package com.app.api;

import com.app.entity.Account;
import com.app.service.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AccountController {
    @Autowired
    AccountServices accountServices;
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<Account> accountList = accountServices.findAll();
        return ResponseEntity.ok(accountList);
    }
}
