package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "PERSON_BOOKING")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PersonBooking extends BaseEntity {
    private String fullName;
    private Date birthday;
    private boolean gender;
    private String relationship;

    @ManyToOne
    @JoinColumn(name = "BOOKING_ID", referencedColumnName = "ID")
    private Booking bookingId;

}
