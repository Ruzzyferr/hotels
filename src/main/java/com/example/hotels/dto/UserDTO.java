package com.example.hotels.dto;

import com.example.hotels.enums.Role;
import lombok.Data;


@Data
public class UserDTO {

    private int id;

    private String name;

    private String username;

    private Role role;

    private Boolean active;

}
