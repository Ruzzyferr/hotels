package com.example.hotels.entity;

import com.example.hotels.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean active;


}
