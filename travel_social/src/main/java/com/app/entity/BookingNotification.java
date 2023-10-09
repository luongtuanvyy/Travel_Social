package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "BOOKING_NOTIFICATION")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BookingNotification extends BaseEntity{

    @Column(name = "NOTIFICATION_TYPE")
    private String notificationType;

    @Column(name = "CREATE_TIME")
    private LocalTime createTime;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;
}
