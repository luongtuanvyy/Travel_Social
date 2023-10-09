package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PLACE")
public class Place extends BaseEntity{
    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "WEBSITE")
    private String website;

    @Column(name = "HOTLINE")
    private String hotline;

    @Column(name = "VERIFY")
    private boolean verify;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;


}
