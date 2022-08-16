package com.example.hotels.mapper;


import com.example.hotels.dto.ReservationDTO;
import com.example.hotels.dto.ReservationSaveDTO;
import com.example.hotels.dto.ReservationStatusDTO;
import com.example.hotels.entity.Reservation;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Named("toEntity")
    Reservation toEntity (ReservationDTO dto);

    @Named("toDto")
    ReservationDTO toDto (Reservation entity);

    @IterableMapping(qualifiedByName = "toDto")
    List<ReservationDTO> toDTOList (List<Reservation> entityList);

    Reservation toEntityFromSaveRequestDTO (ReservationSaveDTO dto);

    Reservation toEntityFromStatusDTO (ReservationStatusDTO dto);

}
