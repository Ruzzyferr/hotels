package com.example.hotels.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private int id;

    private String name;

    private String surname;

    private String tc;

    private String passportNo;

    private String email;

    private Boolean active;

}
