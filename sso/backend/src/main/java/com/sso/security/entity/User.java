package com.sso.security.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;


@Data
@Entity
@Builder
@Table(name = "sso_user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column
    private  String name;
    @Column
    private  String email;
    @Column
    private  String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
}
