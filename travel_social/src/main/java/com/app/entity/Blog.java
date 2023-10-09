package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "BLOG")
public class Blog extends BaseEntity {

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "PLACE_ID", nullable = false)
    private Place place;
}
