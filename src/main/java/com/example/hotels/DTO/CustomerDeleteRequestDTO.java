package com.example.hotels.DTO;

import lombok.Data;

@Data
public class CustomerDeleteRequestDTO {

    private int id;

    private String name;

    private String surname;

    private String tc = null;

    private String passportNo = null;

    private Boolean active = false;

}
