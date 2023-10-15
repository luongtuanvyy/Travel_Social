package com.app.api.api_Auth;

import com.app.payload.request.AuthenticationRequest;
import com.app.payload.request.RegistrationRequest;
import com.app.payload.response.APIResponse;
import com.app.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @PostMapping(path = "/register", consumes = {"multipart/form-data"})
    public ResponseEntity<?>register(
            @RequestPart(name = "account") RegistrationRequest registrationRequest,
            @RequestPart(name = "file",required = false) MultipartFile file ){
        APIResponse apiResponse= null;
        if (file != null){
            System.out.println("file");
            apiResponse= authService.register(registrationRequest,file);
            return  ResponseEntity.ok(apiResponse);
        }
        System.out.println("nofile");
        apiResponse = authService.register(registrationRequest);
        return  ResponseEntity.ok(apiResponse);
    }
}
