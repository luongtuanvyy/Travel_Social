package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "BOOKING_CANCEL")
@AllArgsConstructor
@NoArgsConstructor
public class BookingCancel extends BaseEntity{
    @Column(name = "CURRENCY")
    private BigDecimal currency;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;
}
