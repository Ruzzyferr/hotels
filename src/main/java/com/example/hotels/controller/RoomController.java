package com.example.hotels.controller;

import com.example.hotels.dto.RoomDTO;
import com.example.hotels.dto.RoomSaveRequestDTO;
import com.example.hotels.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;


    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/save")
    public ResponseEntity<RoomDTO> save(@RequestBody RoomSaveRequestDTO dto){
        RoomDTO roomDTO = roomService.save(dto);
        return new ResponseEntity<>(roomDTO, HttpStatus.OK);
    }

}
