package com.example.hotels.service;

import com.example.hotels.dto.CustomerDTO;
import com.example.hotels.dto.ReservationDTO;
import com.example.hotels.dto.ReservationSaveDTO;
import com.example.hotels.entity.Reservation;
import com.example.hotels.mapper.ReservationMapper;
import com.example.hotels.repository.CustomerRepository;
import com.example.hotels.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    public ReservationService(ReservationMapper reservationMapper, ReservationRepository reservationRepository, CustomerRepository customerRepository) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;
    }



    public ReservationDTO save(ReservationSaveDTO dto){


        Reservation reservation = reservationMapper.toEntityFromSaveRequestDTO(dto);

        CustomerDTO customerDTO = (CustomerDTO) dto.getCustomer();
        customerRepository.findByIdAndActiveTrue(customerDTO.getId()).orElseThrow(() -> new RuntimeException(" Active Customer could not found with id "));

            reservation = reservationRepository.save(reservation);

            ReservationDTO dto2 = reservationMapper.toDto(reservation);
           return dto2;


    }

}
