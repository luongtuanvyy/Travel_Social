package com.app.service;

import com.app.entity.Account;
import com.app.entity.UserDetail;
import com.app.payload.request.AuthenticationRequest;
import com.app.payload.request.RegistrationRequest;
import com.app.payload.response.APIResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AuthService {
    APIResponse login(AuthenticationRequest authenticationRequest);
    APIResponse register(RegistrationRequest registrationRequest);

    APIResponse register (RegistrationRequest registrationRequest, MultipartFile file);
    APIResponse logout();

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
