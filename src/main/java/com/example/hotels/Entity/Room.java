package com.example.hotels.Entity;

import com.example.hotels.Enum.RoomType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private RoomType roomType;

    private int floor;

    private int customer_id;

    private boolean active;

}
