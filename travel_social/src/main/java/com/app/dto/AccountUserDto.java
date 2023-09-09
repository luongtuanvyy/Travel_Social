package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUserDto {
    private String user_name;
    private String full_name;
    private String email;
    private Boolean gender;
    private String phone_number;
    private String avatar;
    private LocalDateTime birth_day;
    private String role;
}
