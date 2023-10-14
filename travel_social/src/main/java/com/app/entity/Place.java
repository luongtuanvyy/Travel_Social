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
@Table(name = "PLACE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Place extends BaseEntity {
    private String name;
    private String address;
    private String description;
    private String website;
    private String hotline;
    private String type;
    private String image;
    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;
}
