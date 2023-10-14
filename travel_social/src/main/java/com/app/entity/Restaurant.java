package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RESTAURANT")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Restaurant extends BaseEntity {
    private String name;
    private String website;
    private String address;
    private String image;
    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;
}
