package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@Table(name = "FAVORITE")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Favorite extends BaseEntity{
    @Column(name = "NOTIFICATION_TYPE")
    private  String notification_type;



    @Temporal(TemporalType.DATE)
    @Column(name = "FAVORITE_TIME")
    private Date favorite_time;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "id")
    private Tour tour;

}
