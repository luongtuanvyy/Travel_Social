package com.app.entity;

import com.app.type.EBlogNotification;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BLOG_NOTIFICATION")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BlogNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOTIFICATION_TYPE")
    private EBlogNotification notificationType;

    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "BLOG_ID", referencedColumnName = "ID")
    private Blog blogId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    private Account accountId;
}
