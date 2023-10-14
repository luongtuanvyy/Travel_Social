package com.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "VIEW")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class View extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "BLOG_ID", referencedColumnName = "ID")
    private Blog blogId;
}
