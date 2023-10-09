package com.app.service.serviceImpl;

import com.app.entity.Account;
import com.app.entity.UserDetail;
import com.app.entity.Users;
import com.app.mapper.AccountMapper;
import com.app.payload.request.AuthenticationRequest;
import com.app.payload.request.RegistrationRequest;
import com.app.payload.response.APIResponse;
import com.app.payload.response.AuthResponse;
import com.app.payload.response.CloudinaryResponse;
import com.app.security.TokenProvider;
import com.app.service.AccountServices;
import com.app.service.AuthService;
import com.app.service.CompanyServices;
import com.app.service.UserServices;
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
    UserServices userServices;
    @Autowired
    CompanyServices companyServices;
    @Autowired
    AccountMapper accountMapper;
    @Override
    public APIResponse login(AuthenticationRequest authenticationRequest) {
        try {
            Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            Account acc = accountServices.findByUsername(authenticationRequest.getUsername()).orElse(null);
            if(acc == null){
                return APIResponse.builder().message("Username or password is incorrect").success(false).build();
            }
            String token =tokenProvider.generateToken(acc);

            String refreshtoken = tokenProvider.genarateRefershTolen(acc);
            Object object = new Object();
            if(acc.getUser() == null){
                object = accountMapper.accountCompanyDto(acc);
            }else{
                object = accountMapper.accountUserDto(acc);
            }
            AuthResponse authResponse = new AuthResponse(token,refreshtoken ,object);
        return APIResponse.builder().message("Success").success(true).data(authResponse).build();
        }catch (Exception e){
            e.printStackTrace();
           return APIResponse.builder().message("Username or password is incorrect").success(false).build();
        }
    }

    @Override
    public APIResponse register(RegistrationRequest registrationRequest) {
        Account exists =  accountServices.findByUsername(registrationRequest.getAccount().getUser_name()).orElse(null);
        Users usercheck = userServices.findByEmail(registrationRequest.getUsers().getEmail()).orElse(null);
        if(exists != null){
            return APIResponse.builder().message("Username is exists").success(false).build();
        }
        if(usercheck != null ){
            return APIResponse.builder().message("Email is exists").success(false).build();
        }
        registrationRequest.getAccount().setPassword(passwordEncoder.encode(registrationRequest.getAccount().getPassword()));
        registrationRequest.getAccount().setUser(registrationRequest.getUsers());
        registrationRequest.getUsers().setAccount(registrationRequest.getAccount());
        Account regisacc = registrationRequest.getAccount();
        Users regisuser = registrationRequest.getUsers();

        userServices.save(regisuser);
        accountServices.save(regisacc);
//        Users usserceck = userServices.findByEmail(regisuser.getEmail()).get();
//        usserceck.setAccount(regisacc);
//        userServices.save(regisuser);
        return APIResponse.builder().message("Register successfully!").success(true).data(registrationRequest).build();
    }


    @Override
    public APIResponse register(Account account, MultipartFile file) {
        Account exists =  accountServices.findByUsername(account.getUser_name()).orElse(null);
        if(exists != null){
            return APIResponse.builder().message("Email is exists").success(false).build();
        }
        CloudinaryResponse response = cloudinaryService.uploadFile(file, "User");
        String encoderPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encoderPassword);
//        account.setCloudinaryId(response.getCloudinaryId());
//        account.setAvatar(response.getUrl());
        accountServices.save(account);
        return APIResponse.builder().message("Register successfully!").success(true).build();
    }

    @Override
    public APIResponse updateInformation(UserDetail userDetail, Account account, MultipartFile file) {
        return null;
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
