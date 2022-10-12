package com.example.hotels.service;

import com.example.hotels.client.AttendantClient;
import com.example.hotels.dto.JobsDTO;
import com.example.hotels.dto.RoomDTO;
import com.example.hotels.dto.RoomSaveRequestDTO;
import com.example.hotels.entity.Room;
import com.example.hotels.mapper.RoomMapper;
import com.example.hotels.repository.RoomRepository;
import org.springframework.stereotype.Service;
@Service
public class RoomService {

    private final RoomMapper roomMapper;
    private final RoomRepository roomRepository;

    private final AttendantClient attendantClient;

    public RoomService(RoomMapper roomMapper, RoomRepository roomRepository, AttendantClient attendantClient) {
        this.roomMapper = roomMapper;
        this.roomRepository = roomRepository;
        this.attendantClient = attendantClient;
    }

    public RoomDTO save(RoomSaveRequestDTO dto){
        Room room = roomMapper.toRoomFromSaveRequestDto(dto);

        room = roomRepository.save(room);
        return roomMapper.toDto(room);
    }

    public JobsDTO getJobSFromClient(int id) {
        return attendantClient.getJobs(id);
    }

}
