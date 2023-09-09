package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TOUR")
public class Tour extends BaseEntity{

    @Column(name = "NAME")
    private  String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "VEHICAL")
    private  String vehical;

    @Column(name = "DEPATURE")
    private  String depature;

    @Column(name = "DESCRIPTION")
    private  String description;

    @Column(name = "IMG")
    private  String img;

    @Column(name = "cloudinary_id")
    private String cloudinaryId;

    @Column(name = "START_DATE")
    private LocalDateTime start_date;

    @Column(name = "START_END")
    private LocalDateTime start_end;

    @Column(name = "SIZE")
    private Integer size;

    @Column(name = "REGISTERED")
    private Integer REGISTERED;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    private Company company;
}
