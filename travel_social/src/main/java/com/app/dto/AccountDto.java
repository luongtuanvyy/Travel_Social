package com.app.dto;

import com.app.type.ERole;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String accountName;
    private String loginType;
    private ERole role;
    private boolean isVerify;
    private String cloudinaryId;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private boolean vip;
    private String hotline;
    private String description;
    private String avatar;
    private boolean gender;
    private Date birthday;
}
