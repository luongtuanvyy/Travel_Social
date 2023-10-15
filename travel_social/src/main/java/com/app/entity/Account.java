package com.app.entity;

import com.app.type.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Account extends BaseEntity {

    @Column(name = "ACCOUNTNAME", unique = true)
    private String accountname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "LOGIN_TYPE")
    private String loginType;

    @Column(name = "ROLE")
    private ERole role;

    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "EMAIL", unique = true)
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
}
