package com.example.hotels.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date checkInDate;

    private Date checkOutDate;

    private double price;

    private double totalPrice;

    @Column(length = 1000)
    private String note;

    @ManyToOne
    private Room room;

    @ManyToMany
    private Set<Customer> customer;

}
