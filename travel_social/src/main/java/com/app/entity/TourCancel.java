package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "TOUR_CANCEL")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TourCancel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer percent;

    private Integer date;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", referencedColumnName = "ID")
    private Tour tour;
}
