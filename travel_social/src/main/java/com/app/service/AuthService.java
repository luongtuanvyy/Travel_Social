package com.app.service;

import com.app.entity.Account;
import com.app.entity.UserDetail;
import com.app.payload.request.AuthenticationRequest;
import com.app.payload.request.RegistrationRequest;
import com.app.payload.response.APIResponse;
import org.springframework.web.multipart.MultipartFile;

public interface AuthService {
    APIResponse login(AuthenticationRequest authenticationRequest);
    APIResponse register(RegistrationRequest registrationRequest);

    APIResponse register (RegistrationRequest registrationRequest, MultipartFile file);
    APIResponse logout();
}
