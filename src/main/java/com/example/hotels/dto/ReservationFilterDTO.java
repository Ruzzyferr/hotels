package com.example.hotels.dto;

import com.example.hotels.enums.ReservationStatus;
import com.example.hotels.enums.RoomType;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationFilterDTO {

    private Date checkInDate;

    private Date checkInDate2;

    private Date checkOutDate;

    private ReservationStatus status;

    private String roomName;

    private RoomType roomType;

    private String customerName;

}
