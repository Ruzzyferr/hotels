package com.example.hotels.mapper;


import com.example.hotels.dto.ReservationDTO;
import com.example.hotels.dto.ReservationSaveDTO;
import com.example.hotels.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Named("toEntity")
    Reservation toEntity (ReservationDTO dto);

    @Named("toDto")
    ReservationDTO toDto (Reservation entity);

    Reservation toEntityFromSaveRequestDTO (ReservationSaveDTO dto);

}
