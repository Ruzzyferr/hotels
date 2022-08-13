package com.example.hotels.Service;

import com.example.hotels.DTO.RoomDTO;
import com.example.hotels.DTO.RoomDeleteRequestDTO;
import com.example.hotels.DTO.RoomSaveRequestDTO;
import com.example.hotels.Entity.Room;
import com.example.hotels.Mappers.RoomMapper;
import com.example.hotels.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;

    public RoomService(RoomMapper roomMapper, RoomRepository roomRepository) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
    }

    public RoomDTO save(RoomSaveRequestDTO dto){
        Room room = roomMapper.toRoomFromSaveRequestDto(dto);

        room = roomRepository.save(room);
        return roomMapper.toDto(room);
    }

    public RoomDeleteRequestDTO delete(RoomDeleteRequestDTO dto){

        Room room = roomMapper.toRoomFromDeleteRequestDto(dto);
        dto.setActive(false);
        roomRepository.delete(room);

        return dto;
    }

}
