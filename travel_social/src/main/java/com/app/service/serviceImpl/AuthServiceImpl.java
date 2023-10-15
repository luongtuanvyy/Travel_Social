package com.app.service.serviceImpl;

import com.app.dto.AccountDto;
import com.app.entity.Account;
import com.app.entity.Token;
import com.app.entity.UserDetail;
import com.app.mapper.AccountMapper;
import com.app.payload.request.AuthenticationRequest;
import com.app.payload.request.RegistrationRequest;
import com.app.payload.response.APIResponse;
import com.app.payload.response.AuthResponse;
import com.app.payload.response.CloudinaryResponse;
import com.app.repository.TokenRepository;
import com.app.security.TokenAuthenticationFilter;
import com.app.security.TokenProvider;
import com.app.service.AccountServices;
import com.app.service.AuthService;
import com.app.type.TokenType;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    @Autowired
    TokenRepository tokenRepository;
    @Autowired
    UserDetailServices userDetailServices;
    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
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
            var refreshToken = tokenProvider.genarateRefershToken(acc);
            revokeAllUserToken(acc);
            saveAccountToken(acc,token);
            AccountDto accDto = accountMapper.accountDto(acc);
            AuthResponse authResponse = new AuthResponse(token ,refreshToken,accDto);
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
       Account saveAccount = accountServices.save(registrationRequest.getAccount());
       var jwtToken = tokenProvider.generateToken(saveAccount);
       var refreshToken = tokenProvider.genarateRefershToken(saveAccount);
        saveAccountToken(saveAccount, jwtToken);
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
        Account saveAccount = accountServices.save(registrationRequest.getAccount());
        var jwtToken = tokenProvider.generateToken(saveAccount);
        var refreshToken = tokenProvider.genarateRefershToken(saveAccount);
        saveAccountToken(saveAccount, jwtToken);

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

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = tokenProvider.getUsernameFromToken(refreshToken);

        if (userEmail != null) {
            var user =  this.accountServices.findByEmail(userEmail)
                    .orElseThrow();
            if (tokenProvider.validateToken(refreshToken,  user)) {
                var accessToken = tokenProvider.generateToken(user);
                revokeAllUserToken(user);
                saveAccountToken(user, accessToken);
                var authResponse = AuthResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
//        try {
//            String jwt = getJwtFromRequest(request);
//            var isTokenValid = tokenRepository.findByToken(jwt).map(t-> !t.isExpried() && !t.isRevoked())
//                    .orElse(false);
//            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
//                String userName = tokenProvider.getUsernameFromToken(jwt);
//                UserDetails userDetails = userDetailServices.loadUserByUsername(userName);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
////                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                logger.info("Successfully authenticated user");
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            logger.error("Could not set user authentication in security context", ex);
//        }
    }
    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
    private void saveAccountToken(Account saveAccount, String jwtToken) {
        var token = Token.builder().account(saveAccount)
                .token(jwtToken)
                .tokenTye(TokenType.BEARER)
                .revoked(false)
                .expried(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserToken(Account account){
        var validToken = tokenRepository.findAllValidTokensByAccount(account.getId());
        if(validToken.isEmpty())
            return;
        validToken.forEach(t->{
            t.setExpried(true);
            t.setRevoked(true);
        });
        tokenRepository.saveAll(validToken);

    }
}
