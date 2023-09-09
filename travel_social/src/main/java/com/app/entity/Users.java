package com.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
public class Users extends BaseEntity {
    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GENDER")
    private Boolean gender;

    @Column(name = "PROVIDER")
    private Boolean provider;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VIP")
    private Integer vip;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime birth_day;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     @JoinColumn(name = "Account_ID" )
    Account account;

}
