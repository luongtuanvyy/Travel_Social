package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TOUR_GUIDE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TourGuide extends BaseEntity {
    private String fullName;
    private boolean gender;
    private String avatar;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", referencedColumnName = "ID")
    private Tour tourId;
}
