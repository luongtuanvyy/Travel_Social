package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TOUR_GUIDE")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TourGuide extends BaseEntity{
    @Column(name = "FULLNAME")
    private  String fullname;

    @Column(name = "GENDER")
    private  Boolean gender;

    @Column(name = "EMAIL")
    private  String email;

    @Column(name = "PHONE")
    private  String phone;

    @Column(name = "AVATAR")
    private  String avatar;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @Column(name = "ACTIVE")
    private  Boolean active;

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
}
