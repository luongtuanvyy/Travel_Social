package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "BloG_NOTIFICATION")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BlogNotification extends BaseEntity{

    @Column(name = "POST_ID")
    private Integer postId;

    @Column(name = "NOTIFICATION_TYPE")
    private String notificationType;

    @Column(name = "CREATE_TIME")
    private LocalTime createTime;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "id")
    private Account account;


}
