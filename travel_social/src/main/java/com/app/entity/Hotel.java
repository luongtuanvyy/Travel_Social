package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "HOTEL")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Hotel extends BaseEntity{
    @Column(name = "ADDRESS")
    private  String address;

    @Column(name = "NAME")
    private  String name;

    @Column(name = "ROOM")
    private Integer room;

    @Column(name = "HOTLINE")
    private  String hotline;

    @Column(name = "VERIFY")
    private  Boolean verify;

    @Column(name = "TYPE")
    private  String type;

    @Column(name = "RATING")
    private  Float rating;

    @Column(name = "IMAGE")
    private  String image;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @Column(name = "ACTIVE")
    private  Boolean active;

    @Column(name = "DESCRIPTION")
    private  String description;
}
