package com.app.api.api_Auth;

import com.app.payload.request.AuthenticationRequest;
import com.app.payload.request.RegistrationRequest;
import com.app.payload.response.APIResponse;
import com.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    AuthService authService;
    @GetMapping("/login1")
    public ResponseEntity<?> login1(){
        return ResponseEntity.ok("ok - login1");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest){
        APIResponse result = authService.login(authenticationRequest);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        APIResponse response = authService.logout();
        return ResponseEntity.ok(response);
    }
    @PostMapping("/register")
    public ResponseEntity<?>register(@RequestBody RegistrationRequest registrationRequest){
        APIResponse apiResponse= authService.register(registrationRequest);
        return  ResponseEntity.ok(apiResponse);
    }
}
