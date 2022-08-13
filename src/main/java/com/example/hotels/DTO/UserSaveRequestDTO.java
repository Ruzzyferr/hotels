package com.example.hotels.DTO;

import com.example.hotels.Enum.Role;
import lombok.Data;

@Data
public class UserSaveRequestDTO {

    private int id;

    private String name;

    private String username;

    private String password;

    private Role role;

    private Boolean active;

}
