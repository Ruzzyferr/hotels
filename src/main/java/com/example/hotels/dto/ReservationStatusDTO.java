package com.example.hotels.dto;

import com.example.hotels.enums.ReservationStatus;
import lombok.Data;

@Data
public class ReservationStatusDTO {

    private int id;

    private ReservationStatus status;

    private String cancelNote;


}
