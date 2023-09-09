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
@Table(name = "VDEHICAL")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Vehical extends BaseEntity{
    @Column(name = "ADDRESS")
    private  String address;

    @Column(name = "NAME")
    private  String name;

    @Column(name = "HOTLINE")
    private  String hotline;

    @Column(name = "VERIFY")
    private  Boolean verify;

    @Column(name = "ACTIVE")
    private  Boolean active;

    @Column(name = "TYPE")
    private  String type;

    @Column(name = "WEBSITE")
    private  String website;

    @Column(name = "EMAIL")
    private  String email;

    @Column(name = "IMAGE")
    private  String image;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;
}
