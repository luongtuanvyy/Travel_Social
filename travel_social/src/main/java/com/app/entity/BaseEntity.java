package com.app.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//
//    @Column(name = "created_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
//    private Date createdAt;
//
//    @Column(name="created_by")
//    @CreatedBy
//    private String createdBy;
//
//    @Column(name = "modified_at")
//    @LastModifiedDate
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date modifiedAt;
//
//    @Column(name = "modified_by")
//    @LastModifiedBy
//    private String modifiedBy;

}

