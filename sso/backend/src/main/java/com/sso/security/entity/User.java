package com.sso.security.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

@Data
@Entity
@Builder
@Table(name = "sso_user")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column
    @NotNull(message = "name should be provided")
    private  String name;
    @Column
    @NotNull(message = "email should be provided")
    private  String email;
    @Column
    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
    private  String password;

    @Column
    @Enumerated(EnumType.STRING)
    @NotNull(message = "role should be provided")
    private Role role;
}
