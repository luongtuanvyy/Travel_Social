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

    @Column(name = "TIME_START")
    private Timestamp timeStart;

    @Column(name = "TIME_END")
    private Timestamp timeEnd;

    @Column(name = "SIZE")
    private Integer size;

    @Column(name = "PERCENT")
    private Integer percent;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

}
