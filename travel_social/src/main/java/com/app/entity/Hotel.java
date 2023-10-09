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
    private String address;

    @Column(name = "ROOM")
    private int room;

    @Column(name = "HOTLINE")
    private String hotline;

    @Column(name = "VERIFY")
    private boolean verify;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "RATING")
    private float rating;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;
}
