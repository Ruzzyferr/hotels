package com.example.hotels.entity;

import com.example.hotels.enums.ReservationStatus;
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

    private String cancelNote;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    @Column(length = 1000)
    private String note;

    @ManyToOne
    private Room room;

    @ManyToMany(fetch=FetchType.EAGER)
    private Set<Customer> customer;

}
