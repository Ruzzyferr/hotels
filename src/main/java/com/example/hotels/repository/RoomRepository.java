package com.example.hotels.repository;

import com.example.hotels.dto.RoomDTO;
import com.example.hotels.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    RoomDTO findRoomById(RoomDTO roomDTO);
}
