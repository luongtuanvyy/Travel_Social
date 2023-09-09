package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "REVIEW")
public class Review extends BaseEntity{

    @Column(name = "RATING")
    private  Float rating;

    @Column(name = "COMMENT")
    private  String comment;

    @Column(name = "REVIEW_DATE")
    private LocalDateTime review_date;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "cloudinary_id")
    private String cloudinaryId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID")
    private Tour tour;

}
