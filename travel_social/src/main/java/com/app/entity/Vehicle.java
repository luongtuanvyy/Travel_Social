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
@Table(name = "VEHICLE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Vehicle extends BaseEntity {
    private String address;
    private String name;
    private String hotline;
    private String type;
    private String website;
    private String email;
    private String image;
    private String description;
    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;
}
