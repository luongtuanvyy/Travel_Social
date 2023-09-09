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
    @Column(name = "BOOKING_DATE")
    private Timestamp booking_date;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "ADULT")
    private Integer adult;

    @Column(name = "CHILDREN")
    private Integer children;

    @Column(name = "BABY")
    private Integer baby;

    @Column(name = "TOTAL_PRICE")
    private BigDecimal total_price;

    @Column(name = "QR")
    private String qr;

    @Column(name = "CLOUDINARY_ID")
    private String cloudinaryId;

    @Column(name = "ACTIVE")
    private String active;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "PAY_ID")
    private Payment payment;


}
