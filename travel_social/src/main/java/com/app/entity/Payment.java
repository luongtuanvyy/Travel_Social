package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PAYMENT")
public class Payment extends BaseEntity {
    @Column(name = "NAME")
    private  String name;

}
