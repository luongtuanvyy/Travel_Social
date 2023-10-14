package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "HOTEL")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Hotel extends BaseEntity {
    private String name;
    private String address;
    private int room;
    private String hotline;
    private String type;
    private float rating;
    private String image;
    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;
}
