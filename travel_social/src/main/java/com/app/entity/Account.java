package com.app.entity;


import com.app.type.ERole;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account extends BaseEntity {
    @Column(name = "ACCOUNT_NAME", unique = true)
    private String accountName;
    @Column(name = "LOGIN_TYPE")
    private String loginType;
    @Column(name = "ROLE")
    private ERole role;
    @Column(name = "IS_VERIFY")
    private boolean isVerify;
    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    private String password;
    private String address;
    @Column(unique = true)
    private String email;
    private boolean vip;
    private String hotline;
    @Column(name = "description", columnDefinition = "LONGTEXT")
    private String description;
    private String avatar;
    private boolean gender;
    @Column(columnDefinition = "DATE DEFAULT (CURRENT_DATE)")
    private Date birthday;

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", loginType='" + loginType + '\'' +
                ", role=" + role +
                ", isVerify=" + isVerify +
                ", cloudinaryId='" + cloudinaryId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", vip=" + vip +
                ", hotline='" + hotline + '\'' +
                ", description='" + description + '\'' +
                ", avatar='" + avatar + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                '}';
    }
}
