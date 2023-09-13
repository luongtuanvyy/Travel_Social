package com.app.api;

import com.app.payload.request.UserQueryParam;
import com.app.repository.UserRepository;
import com.app.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserApi {

    @Autowired
    UserServices userServices;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/users")
    public ResponseEntity<?> filter(UserQueryParam userQueryParam) {
        return ResponseEntity.ok(userServices.filterUser(userQueryParam));
    }




}


