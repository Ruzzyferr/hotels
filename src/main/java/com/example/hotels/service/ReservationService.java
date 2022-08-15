package com.example.hotels.service;

import com.example.hotels.dto.CustomerDTO;
import com.example.hotels.dto.ReservationDTO;
import com.example.hotels.dto.ReservationSaveDTO;
import com.example.hotels.dto.ReservationStatusDTO;
import com.example.hotels.entity.Reservation;
import com.example.hotels.enums.ErrorType;
import com.example.hotels.enums.ReservationStatus;
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
    public ReservationDTO save(ReservationSaveDTO dto) {

        Reservation reservation = reservationMapper.toEntityFromSaveRequestDTO(dto);

        reservation.setTotalPrice(reservation.getPrice() * (reservation.getCheckOutDate().getDay() - reservation.getCheckInDate().getDay()));

        Set<CustomerDTO> customerSet = dto.getCustomer();
        for (CustomerDTO customerDTO : customerSet) {
            customerRepository.findByIdAndActiveTrue(customerDTO.getId()).orElseThrow(
                    () -> new GenericServiceException(ErrorType.NO_ACTIVE_CUSTOMER,
                            "Active Customer could not found with id " + customerDTO.getId()));
        }
        reservation = reservationRepository.save(reservation);
        reservation.setStatus(ReservationStatus.valueOf("RESERVED"));

        return reservationMapper.toDto(reservation);


    }

    public ReservationDTO setStatus(ReservationStatusDTO dto) {

        Reservation reservation = reservationMapper.toEntityFromStatusDTO(dto);
        String dd;

        if (reservation.getStatus().toString() == "CANCELLED") {
            throw new GenericServiceException(ErrorType.IF_CANCELLED_SET_A_NOTE,
                    "Please add a note for the reason of cancel");
        } else {
            dd = dto.getCancelNote();
        }

        reservation = reservationRepository.findById(reservation.getId()).orElseThrow(() -> new GenericServiceException(ErrorType.NO_ACTIVE_ROOM_WITH_ID,
                "Reservation Could not found with id " + dto.getId())
        );

        reservation.setStatus(dto.getStatus());
        reservation.setCancelNote(dd);

        return reservationMapper.toDto(reservation);
    }
}
