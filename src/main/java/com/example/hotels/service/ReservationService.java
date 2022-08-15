package com.example.hotels.service;

import com.example.hotels.dto.CustomerDTO;
import com.example.hotels.dto.ReservationDTO;
import com.example.hotels.dto.ReservationSaveDTO;
import com.example.hotels.entity.Reservation;
import com.example.hotels.enums.ErrorType;
import com.example.hotels.exception.GenericServiceException;
import com.example.hotels.mapper.ReservationMapper;
import com.example.hotels.repository.CustomerRepository;
import com.example.hotels.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

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


    @Transactional
    public ReservationDTO save(ReservationSaveDTO dto){

        Reservation reservation = reservationMapper.toEntityFromSaveRequestDTO(dto);

        Set<CustomerDTO> customerSet = dto.getCustomer();
        for (CustomerDTO customerDTO : customerSet) {
            customerRepository.findByIdAndActiveTrue(customerDTO.getId()).orElseThrow(() -> new GenericServiceException(ErrorType.NO_ACTIVE_CUSTOMER, "Active Customer could not found with id " + customerDTO.getId()));
        }
        reservation = reservationRepository.save(reservation);

        return reservationMapper.toDto(reservation);


    }

}
