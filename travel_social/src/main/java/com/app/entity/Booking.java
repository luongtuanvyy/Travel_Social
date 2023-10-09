package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "BOOKING")
public class Booking  extends BaseEntity {
    @Column(name = "BOOKING_TIME")
    private Timestamp bookingTime;

    @Column(name = "NOTE", length = 255)
    private String note;

    @Column(name = "ADULT")
    private Integer adult;

    @Column(name = "CHILDREN")
    private Integer children;

    @Column(name = "BABY")
    private Integer baby;

    @Column(name = "QR")
    private String qr;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal totalPrice;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "PAY_ID")
    private Payment payment;


}
