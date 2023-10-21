package com.app.entity;

import com.app.type.EAges;
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
    @Column(columnDefinition = "DATE DEFAULT (CURRENT_DATE)")
    private Date birthday;
    private boolean gender;
    private EAges ages;
    private String relationship;

    @Column(name = "IS_CANCEL")
    private boolean isCancel;
    @ManyToOne
    @JoinColumn(name = "BOOKING_ID", referencedColumnName = "ID")
    private Booking bookingId;
}
