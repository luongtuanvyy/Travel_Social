package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Account extends BaseEntity {

    @Column(name = "ACCOUNTNAME")
    private String accountname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "LOGIN_TYPE")
    private String loginType;

    @Column(name = "ROLE")
    private String role;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "VIP")
    private boolean vip;

    @Column(name = "HOTLINE")
    private String hotline;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "GENDER")
    private boolean gender;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "ACCOUNT_ID")
    private int accountId;


}
