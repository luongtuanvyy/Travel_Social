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
    @Column(name = "FULLNAME")
    private  String fullname;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "GENDER")
    private  Boolean gender;

    @Column(name = "RELATIONSHIP")
    private  String relationship;

    @OneToOne
    @JoinColumn(name = "id")
    private PersonBooking personBooking;

}
