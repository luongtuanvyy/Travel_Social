package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ACCOUNT")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Account extends BaseEntity {
    @Column(name = "USERNAME" )
    private String user_name;

    @Column(name = "PASSWORD" )
    private String password;

    @Column(name = "LOGIN_TYPE" )
    private String login_type;

    @Column(name = "ROLE")
    private String role;

}
