package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "BOOKING_NOTIFICATION")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BookingNotification extends BaseEntity{
    @Column(name = "NOTIFICATION_TYPE")
    private  String notification_type;


    @Column(name = "CREATE_TIME")
    private Timestamp create_time;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;
}
