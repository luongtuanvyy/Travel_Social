package com.app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "BLOG_REACTION")
public class Blog_Reaction extends BaseEntity  {


    @Column(name = "REACTION_LIKE")
    private boolean reactionLike;

    @Column(name = "SHARE")
    private boolean share;

    @Column(name = "COMMENT", length = 255)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "BLOG_ID", nullable = false)
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", nullable = false)
    private Account account;
}
