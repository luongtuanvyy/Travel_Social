package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Account extends BaseEntity {
    private String password;
    private String role;
    private String address;
    private String email;
    private boolean vip;
    private String hotline;
    private String description;
    private String avatar;
    private boolean gender;
    private Date birthday;
    @Column(name = "IS_VERIFY")
    private boolean isVerify;
    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ACCOUNT_NAME")
    private String accountName;
    @Column(name = "LOGIN_TYPE")
    private String loginType;
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;
}
