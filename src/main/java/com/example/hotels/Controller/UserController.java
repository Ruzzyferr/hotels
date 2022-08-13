package com.example.hotels.Controller;

import com.example.hotels.DTO.UserDTO;
import com.example.hotels.DTO.UserSaveRequestDTO;
import com.example.hotels.Service.UserService;
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
