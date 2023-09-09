package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "BLOG")
public class Blog extends BaseEntity {
    @Column(name = "TITLE")
    private  String title;

    @Column(name = "DESCRIPTION")
    private  String description;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @Column(name = "CREATE_TIME")
    private Timestamp create_time;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "ACTIVE")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "PLACE_ID", nullable = false)
    private Place place;
}
