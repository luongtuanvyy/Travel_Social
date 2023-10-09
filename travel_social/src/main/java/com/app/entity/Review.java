package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "REVIEW")
public class Review extends BaseEntity{

    @Column(name = "RATING")
    private Float rating;

    @Column(name = "REVIEW_DATE")
    private LocalDateTime reviewDate;

    @Column(name = "IMAGE")
    private String image;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID")
    private Tour tour;

}
