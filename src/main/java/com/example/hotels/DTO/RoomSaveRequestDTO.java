package com.example.hotels.DTO;

import com.example.hotels.Enum.RoomType;
import lombok.Data;

@Data
public class RoomSaveRequestDTO {

    private int id;

    private RoomType roomType;

    private int floor;

    private int customer_id;

    private boolean active;

}
