package com.example.hotels.mapper;

import com.example.hotels.dto.RoomDTO;
import com.example.hotels.dto.RoomSaveRequestDTO;
import com.example.hotels.entity.Room;
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

    @IterableMapping(qualifiedByName = "toDto")
    List<RoomDTO> toDtoList (List<Room> entityList);
    @IterableMapping(qualifiedByName = "toEntity")
    List<Room> toRoomList (List<RoomDTO> dtoList);

}
