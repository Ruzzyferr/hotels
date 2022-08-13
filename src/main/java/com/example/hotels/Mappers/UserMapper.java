package com.example.hotels.Mappers;

import com.example.hotels.DTO.UserDTO;
import com.example.hotels.DTO.UserSaveRequestDTO;
import com.example.hotels.Entity.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserMapper {
    @Named("toDto")
    UserDTO toDto (User entity);

    @Named("toEntity")
    User toEntity (UserDTO dto);

    User toUserFromSaveRequestDto (UserSaveRequestDTO dto);

    @IterableMapping(qualifiedByName = "toDto")
    List<UserDTO> toDtoList (List<User> entityList);

    @IterableMapping(qualifiedByName = "toEntity")
    List<User> toEntityList (List<UserDTO> dtoList);

}
