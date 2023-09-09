package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCompanyDto {
    private String user_name;
    private String role;
    private String name;
    private Boolean vip;
    private String address;
    private String email;
    private String phone_number;
    private String decription;
}
