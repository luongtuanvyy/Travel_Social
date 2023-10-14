package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "FOLLOW")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Follow extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "FOLLOWER_ID", referencedColumnName = "ID")
    private Account followerId;
}
