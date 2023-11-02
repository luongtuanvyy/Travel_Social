package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BLOG")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Blog extends BaseEntity {
    private String image;
    private String description;

    @Column(name = "IS_VERIFY")
    private boolean isVerify;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @ManyToOne
    @JoinColumn(name = "PLACE_ID", referencedColumnName = "ID")
    private Place placeId;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", referencedColumnName = "ID")
    private Tour tourId;

//    @ManyToOne
//    @JoinColumn(name = "BLOG_ID", referencedColumnName = "ID")
//    private Blog blogId;
}
