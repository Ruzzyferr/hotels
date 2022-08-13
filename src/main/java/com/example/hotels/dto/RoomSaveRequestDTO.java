package com.example.hotels.dto;

import com.example.hotels.enums.RoomType;
import lombok.Data;

@Data
public class RoomSaveRequestDTO {

    private int id;

    private String name;

    private RoomType roomType;

    private int floor;

    private boolean active;

}
