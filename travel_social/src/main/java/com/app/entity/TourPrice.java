package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "TOUR_PRICE")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TourPrice extends BaseEntity{


    @Column(name = "ADULT")
    private BigDecimal adult;

    @Column(name = "CHILDREN")
    private BigDecimal children;

    @Column(name = "BABY")
    private BigDecimal baby;

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    private Tour tour;
}
