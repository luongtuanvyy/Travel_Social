package com.app.dto;

import com.app.type.ERole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String user_name;
    private String full_name;
    private String email;
    private Boolean gender;
    private String phone_number;
    private String avatar;
    private Date birth_day;
    private ERole role;
}
