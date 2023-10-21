package com.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BLOG_REACTION")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class BlogReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean share;
    @Column(columnDefinition = "LONGTEXT")
    private String comment;

    @Column(name = "REACTION_LIKE")
    private boolean reactionLike;
    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "BLOG_ID", referencedColumnName = "ID")
    private Blog blogId;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    private Account accountId;
}
