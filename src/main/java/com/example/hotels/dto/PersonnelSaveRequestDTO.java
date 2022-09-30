package com.example.hotels.dto;

import com.example.hotels.enums.Jobs;
import com.example.hotels.enums.Role;
import lombok.Data;

@Data
public class PersonnelSaveRequestDTO {

    private int id;

    private String name;

    private String surname;

    private Jobs jobs;

    private String role;

}
