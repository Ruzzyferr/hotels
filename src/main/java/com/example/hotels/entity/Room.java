package com.example.hotels.entity;

import com.example.hotels.enums.RoomType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    private String name;

    private int floor;

    private boolean active;

}
