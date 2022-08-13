package com.example.hotels.DTO;

import com.example.hotels.Enum.Role;
import lombok.Data;


@Data
public class UserDTO {

    private int id;

    private String name;

    private String username;

    private Role role;

    private Boolean active;

}
