package com.example.hotels.Mappers;

import com.example.hotels.DTO.RoomDTO;
import com.example.hotels.DTO.RoomDeleteRequestDTO;
import com.example.hotels.DTO.RoomSaveRequestDTO;
import com.example.hotels.Entity.Room;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    @Named("toDto")
    RoomDTO toDto (Room entity);
    @Named("toEntity")
    Room toEntity (RoomDTO dto);

    Room toRoomFromSaveRequestDto (RoomSaveRequestDTO dto);

    Room toRoomFromDeleteRequestDto (RoomDeleteRequestDTO dto);

    @IterableMapping(qualifiedByName = "toDto")
    List<RoomDTO> toDtoList (List<Room> entityList);
    @IterableMapping(qualifiedByName = "toEntity")
    List<Room> toRoomList (List<RoomDTO> dtoList);

}
