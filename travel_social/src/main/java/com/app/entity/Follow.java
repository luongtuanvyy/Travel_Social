package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "FOLLOW")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Follow extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "id")
    private Account account_fl;

    @Column(name = "follow_time")
    private LocalDateTime follow_time;
}
