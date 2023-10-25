package com.app.api;


import com.app.payload.response.APIResponse;
import com.app.service.MailerService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class OtpApi {
    @Autowired
    MailerService mailerService;

    @GetMapping("/otp")
    public ResponseEntity<?> getOTP(@RequestParam("gmail") String gmail) throws MessagingException {
        APIResponse response = mailerService.OTP(gmail);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
