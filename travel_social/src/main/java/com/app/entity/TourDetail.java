package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "TOUR_DETAIL")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TourDetail extends BaseEntity{
    @Column(name = "DESCRIPTION")
    private  String description;

    @Column(name = "ACTIVE")
    private  Boolean active;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATES")
    private Date dates;

    @Temporal(TemporalType.TIME)
    @Column(name = "TIMES")
    private Date times;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", referencedColumnName = "id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "PLACE_ID", referencedColumnName = "id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "RÉTAURANT_ID")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "VEHICAL_ID")
    private Vehical vehicle;
}
