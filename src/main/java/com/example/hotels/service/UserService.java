package com.example.hotels.service;

import com.example.hotels.dto.UserDTO;
import com.example.hotels.dto.UserSaveRequestDTO;
import com.example.hotels.entity.User;
import com.example.hotels.mapper.UserMapper;
import com.example.hotels.repository.UserRepository;
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
