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
@Table(name = "RESTAURANT")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Restaurant extends BaseEntity{
    @Column(name = "ADDRESS")
    private  String address;

    @Column(name = "NAME")
    private  String name;

    @Column(name = "WEBSITE")
    private  String website;

    @Column(name = "VERIFY")
    private  Boolean verify;

    @Column(name = "IMAGE")
    private  String image;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @Column(name = "ACTIVE")
    private  Boolean active;
}
