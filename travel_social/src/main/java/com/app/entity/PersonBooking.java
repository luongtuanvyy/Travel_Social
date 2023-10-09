package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "PERSON_BOOKING")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PersonBooking extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "BOOKING_ID")
    private Booking booking;

    @Column(name = "FULLNAME")
    private String fullname;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "GENDER")
    private boolean gender;

    @Column(name = "RELATIONSHIP")
    private String relationship;


}
