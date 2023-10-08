package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@Entity
@Table(name = "TOUR_CANCEL")
@AllArgsConstructor
@NoArgsConstructor
public class TourCancel extends BaseEntity {
    @Column(name = "PERCENT")
    private Integer first_name;

    @Column(name = "DATE")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID")
    private Tour tour;

}
