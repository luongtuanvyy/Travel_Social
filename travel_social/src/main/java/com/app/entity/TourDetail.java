package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TOUR_DETAIL")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TourDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", referencedColumnName = "id")
    private Tour tourId;

    @ManyToOne
    @JoinColumn(name = "PLACE_ID", referencedColumnName = "id")
    private Place placeId;

    @ManyToOne
    @JoinColumn(name = "HOTEL_ID", referencedColumnName = "id")
    private Hotel hotelId;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", referencedColumnName = "id")
    private Restaurant restaurantId;

    @ManyToOne
    @JoinColumn(name = "VEHICLE_ID", referencedColumnName = "id")
    private Vehicle vehicleId;
}
