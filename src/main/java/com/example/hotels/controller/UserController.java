package com.example.hotels.controller;

import com.example.hotels.dto.UserDTO;
import com.example.hotels.dto.UserSaveRequestDTO;
import com.example.hotels.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@RequestBody UserSaveRequestDTO dto){
        UserDTO userDTO = userService.save(dto);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

}


