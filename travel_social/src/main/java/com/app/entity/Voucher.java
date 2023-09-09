package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "VOUCHER")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Voucher extends BaseEntity{

    @Column(name = "SIZA")
    private Integer siza;

    @Column(name = "PERCENT")
    private Integer percent;

    @Column(name = "TIME_START")
    private Timestamp time_start;

    @Column(name = "TIME_END")
    private Timestamp time_end;

    @Column(name = "ACTIVE")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

}
