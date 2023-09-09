package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "COMPANY")
public class Company extends BaseEntity {
    @Column(name = "NAME")
    private  String name;

    @Column(name = "VIP")
    private  Boolean VIP;

    @Column(name = "ADDRESS")
    private  String address;

    @Column(name = "EMAIL")
    private  String email;

    @Column(name = "HOTLINE")
    private  String hotline;

    @Column(name = "DECRIPTION")
    private  String description;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @Column(name = "ACTIVE")
    private Boolean active;

    @OneToOne
    @JoinColumn(name = "ACCOUNT_ID")
    Account account;
}
