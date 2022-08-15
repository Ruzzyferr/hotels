package com.example.hotels.controller;

import com.example.hotels.dto.ReservationDTO;
import com.example.hotels.dto.ReservationSaveDTO;
import com.example.hotels.dto.RoomSaveRequestDTO;
import com.example.hotels.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/save")
    public ResponseEntity<ReservationDTO> save(@RequestBody ReservationSaveDTO dto){
        ReservationDTO reservationDTO = reservationService.save(dto);

        return new ResponseEntity<>(reservationDTO, HttpStatus.OK);
    }

}
