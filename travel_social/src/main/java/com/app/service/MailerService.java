package com.app.service;


import com.app.entity.MailInfo;
import com.app.payload.response.APIResponse;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;




@Service
public interface MailerService {
	void send(MailInfo mail) throws MessagingException;

	void send(String to, String subject, String body) throws MessagingException;

	APIResponse OTP(String gmail) throws MessagingException;
	
	
	
}
