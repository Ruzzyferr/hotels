package com.example.hotels.DTO;

import lombok.Data;

@Data
public class CustomerDTO {

    private int id;

    private String name;

    private String surname;

    private String tc;

    private String passportNo;

    private Boolean active;

}
