package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "TOUR")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Tour extends BaseEntity {
    private String name;
    private BigDecimal price;
    private String departure;
    private String description;
    private String image;
    private Integer size;
    private Integer registered;

    @Column(name = "IS_VERIFY")
    private boolean isVerify;
    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @Column(name = "START_DATE_BOOKING")
    private LocalDateTime startDateBooking;
    @Column(name = "END_DATE_BOOKING")
    private LocalDateTime endDateBooking;

    @Column(name = "START_DATE")
    private LocalDateTime startDate;
    @Column(name = "END_DATE")
    private LocalDateTime startEnd;
}
