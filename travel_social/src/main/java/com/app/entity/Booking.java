package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "BOOKING")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Booking extends BaseEntity {
    private String note;
    private Integer adult;
    private Integer children;
    private Integer baby;
    private String qr;
    private String status;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", referencedColumnName = "ID")
    private Tour tourId;

    @ManyToOne
    @JoinColumn(name = "PAYMENT_ID", referencedColumnName = "ID")
    private Payment paymentId;
}
