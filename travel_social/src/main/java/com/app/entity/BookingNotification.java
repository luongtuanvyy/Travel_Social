package com.app.entity;

import com.app.type.EBooking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOOKING_NOTIFICATION")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BookingNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOTIFICATION_TYPE")
    private EBooking notificationType;

    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID", referencedColumnName = "ID")
    private Booking bookingId;
}
