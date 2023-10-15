package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PAYMENT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Payment extends BaseEntity {
    private String name;
}
