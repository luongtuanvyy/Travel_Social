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
    private String fullname;

    @Column(name = "GENDER")
    private boolean gender;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "id")
    private Account account;
}
