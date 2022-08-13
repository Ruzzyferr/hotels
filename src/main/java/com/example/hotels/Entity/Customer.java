package com.example.hotels.Entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;

    private String tc;

    private String passportNo;

    private Boolean active;

}
