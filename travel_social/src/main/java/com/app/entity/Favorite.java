package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "FAVORITE")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Favorite extends BaseEntity {
    @Column(name = "NOTIFICATION_TYPE")
    private String notificationType;

    @ManyToOne
    @JoinColumn(name = "TOUR_ID", referencedColumnName = "ID")
    private Tour tourId;
}
