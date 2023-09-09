package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "BLOG_REACTION")
public class Blog_Reaction extends BaseEntity  {

    @Column(name = "LIKES")
    private  Boolean likes;

    @Column(name = "SHARE")
    private  Boolean share;

    @Column(name = "COMMENT")
    private  String comment;

    @Column(name = "TIME_LIKE")
    private Timestamp time_like;

    @Column(name = "TIME_SHARE")
    private Timestamp time_share;

    @Column(name = "TIME_COMMENT")
    private Timestamp time_comment;

    @ManyToOne
    @JoinColumn(name = "BLOG_ID", nullable = false)
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;
}
