package com.example.hotels.Entity;

import com.example.hotels.Enum.Role;
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
