package com.example.hotels.dto;

import lombok.Data;

import java.util.Date;
import java.util.Set;
@Data
public class ReservationDTO {

    private int id;

    private Date checkInDate;

    private Date checkOutDate;

    private double price;

    private double totalPrice;

    private String note;

    private RoomDTO room;

    private Set<CustomerDTO> customer;

}
