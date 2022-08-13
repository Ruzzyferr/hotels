package com.example.hotels.Service;

import com.example.hotels.DTO.UserDTO;
import com.example.hotels.DTO.UserSaveRequestDTO;
import com.example.hotels.Entity.User;
import com.example.hotels.Mappers.UserMapper;
import com.example.hotels.repository.UserRepository;
import com.sun.xml.bind.v2.runtime.output.Encoded;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    public UserService(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    public UserDTO save(UserSaveRequestDTO dto){

        User user = userMapper.toUserFromSaveRequestDto(dto);
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

}
