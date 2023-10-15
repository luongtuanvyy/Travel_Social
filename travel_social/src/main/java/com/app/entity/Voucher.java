package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "VOUCHER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Voucher extends BaseEntity {
    @Column(name = "TIME_START")
    private Timestamp timeStart;

    @Column(name = "TIME_END")
    private Timestamp timeEnd;

    @Column(name = "SIZE")
    private Integer size;

    @Column(name = "PERCENT")
    private Integer percent;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", referencedColumnName = "ID")
    private Tour tourId;
}
