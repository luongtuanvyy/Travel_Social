package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TOUR")
public class Tour extends BaseEntity{

    @Column(name = "NAME")
    private  String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "DEPATURE")
    private  String depature;

    @Column(name = "DESCRIPTION")
    private  String description;

    @Column(name = "IMAGE")
    private  String image;

    @Column(name = "cloudinary_id")
    private String cloudinaryId;

    @Column(name = "START_DATE_BOOKING")
    private Timestamp start_date_booking;

    @Column(name = "START_DATE")
    private Timestamp start_date;

    @Column(name = "END_DATE_BOOKING")
    private Timestamp start_end_booking;

    @Column(name = "END_DATE")
    private Timestamp start_end;

    @Column(name = "SIZE")
    private Integer size;

    @Column(name = "REGISTED")
    private Integer registed;

    @Column(name = "ACTIVE")
    private Integer active;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;
}
