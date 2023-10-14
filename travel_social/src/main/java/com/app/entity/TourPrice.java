package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "TOUR_PRICE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TourPrice extends BaseEntity {
    private BigDecimal adult;
    private BigDecimal children;
    private BigDecimal baby;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", referencedColumnName = "ID")
    private Tour tourId;
}
