package com.app.service.serviceImpl;

import com.app.dto.AccountDto;
import com.app.entity.Account;
import com.app.entity.UserDetail;
import com.app.mapper.AccountMapper;
import com.app.payload.request.AuthenticationRequest;
import com.app.payload.request.RegistrationRequest;
import com.app.payload.response.APIResponse;
import com.app.payload.response.AuthResponse;
import com.app.payload.response.CloudinaryResponse;
import com.app.security.TokenProvider;
import com.app.service.AccountServices;
import com.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AccountServices accountServices;
    @Autowired
    TokenProvider tokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    CloudinaryService cloudinaryService;
    @Autowired
    AccountMapper accountMapper;
//    @Autowired
//    AccountMapper accountMapper;
    @Override
    public APIResponse login(AuthenticationRequest authenticationRequest) {
        try {
            Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Account acc = accountServices.findByAccountName(authenticationRequest.getUsername()).orElse(null);

            if(acc == null){
                return APIResponse.builder().message("Username or password is incorrect").success(false).build();
            }
            String token =tokenProvider.generateToken(acc);
            String refreshtoken = tokenProvider.genarateRefershTolen(acc);
            AccountDto accDto = accountMapper.accountDto(acc);
            AuthResponse authResponse = new AuthResponse(token,refreshtoken ,accDto);
        return APIResponse.builder().message("Success").success(true).data(authResponse).build();
        }catch (Exception e){
            e.printStackTrace();
           return APIResponse.builder().message("Username or password is incorrect").success(false).build();
        }
    }

    @Override
    public APIResponse register(RegistrationRequest registrationRequest) {
        Account exists =  accountServices.findByAccountName(registrationRequest.getAccount().getAccountName()).orElse(null);
        if(exists != null){
            if(exists.getEmail().equals(registrationRequest.getAccount().getEmail())){
                return APIResponse.builder().message("Email is exists").success(false).build();
            }
            return APIResponse.builder().message("Username is exists").success(false).build();
        }

        registrationRequest.getAccount().setPassword(passwordEncoder.encode(registrationRequest.getAccount().getPassword()));

        accountServices.save(registrationRequest.getAccount());
        return APIResponse.builder().message("Register successfully!").success(true).data(registrationRequest).build();
    }


    @Override
    public APIResponse register(RegistrationRequest registrationRequest, MultipartFile file) {
        Account exists =  accountServices.findByAccountName(registrationRequest.getAccount().getAccountName()).orElse(null);
        if(exists != null){
            return APIResponse.builder().message("Email is exists").success(false).build();
        }
        CloudinaryResponse response = cloudinaryService.uploadFile(file, "account/avt");
        String encoderPassword = passwordEncoder.encode(registrationRequest.getAccount().getPassword());
        registrationRequest.getAccount().setPassword(encoderPassword);
        registrationRequest.getAccount().setCloudinaryId(response.getCloudinaryId());
        registrationRequest.getAccount().setAvatar(response.getUrl());
        accountServices.save(registrationRequest.getAccount());
        return APIResponse.builder().message("Register successfully!").success(true).data(registrationRequest).build();
    }

    @Override
    public APIResponse logout() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated()) {
                SecurityContextHolder.clearContext();
                return APIResponse.builder().message("Logout successful").success(true).build();
            } else {
                return APIResponse.builder().message("User not logged in").success(false).build();
            }
        } catch (Exception ex) {
            return APIResponse.builder().message("Logout failed").success(false).build();
        }
    }
}
