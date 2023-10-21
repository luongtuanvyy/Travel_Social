package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TOUR_TEMPLATE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TourTemplate extends BaseEntity{
    private String name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;
}
