package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Likes")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Like extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "FOLLOWER_ID", referencedColumnName = "ID")
    private Account followerId;
}
