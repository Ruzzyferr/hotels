package com.example.hotels.service;

import com.example.hotels.dto.*;
import com.example.hotels.entity.Customer;
import com.example.hotels.entity.Reservation;
import com.example.hotels.enums.ErrorType;
import com.example.hotels.enums.ReservationStatus;
import com.example.hotels.exception.GenericServiceException;
import com.example.hotels.mapper.ReservationMapper;
import com.example.hotels.repository.CustomerRepository;
import com.example.hotels.repository.ReservationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class ReservationService {

    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    private Join<Reservation, Customer> customerJoin;

    public Join<Reservation, Customer> getCustomerJoin(Root<Reservation> root) {
        if (customerJoin == null) {
            customerJoin = root.join("customer");
        }
        return customerJoin;
    }

    public ReservationService(ReservationMapper reservationMapper, ReservationRepository reservationRepository, CustomerRepository customerRepository) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
        this.customerRepository = customerRepository;

    }


    @Transactional
    public ReservationDTO save(ReservationSaveDTO dto) {

        Reservation reservation = reservationMapper.toEntityFromSaveRequestDTO(dto);

        long difference = dto.getCheckOutDate().getTime() - dto.getCheckInDate().getTime();
        float daysBetween = (difference / (1000*60*60*24));

        reservation.setTotalPrice(reservation.getPrice() * daysBetween);

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
        String cancelNote;

        if (Objects.equals(reservation.getStatus().toString(), "CANCELLED") && !Objects.nonNull(dto.getCancelNote())) {
            throw new GenericServiceException(ErrorType.IF_CANCELLED_SET_A_NOTE,
                    "Please add a note for the reason of cancel");
        } else {
            cancelNote = dto.getCancelNote();
        }

        reservation = reservationRepository.findById(reservation.getId()).orElseThrow(() -> new GenericServiceException(ErrorType.NO_ACTIVE_ROOM_WITH_ID,
                "Reservation Could not found with id " + dto.getId())
        );

        reservation.setStatus(dto.getStatus());
        reservation.setCancelNote(cancelNote);

        return reservationMapper.toDto(reservationRepository.save(reservation));
    }

    public List<ReservationDTO> filterReservations(ReservationFilterDTO dto) {

        Page<Reservation> page = reservationRepository.findAll((root, query, criteriaBuilder) ->  {
            query.distinct(true);
            query.orderBy(criteriaBuilder.asc(root.get("checkInDate")));

            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(dto.getStatus())) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("status"), dto.getStatus())));
            }

            if (Objects.nonNull(dto.getRoomName())) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("room").get("name"), dto.getRoomName())));
            }

            if (Objects.nonNull(dto.getCheckInDate()) && Objects.nonNull(dto.getCheckInDate2())) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get("checkInDate"), dto.getCheckInDate(), dto.getCheckInDate2())));
            }else if (Objects.nonNull(dto.getCheckInDate())) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("checkInDate"), dto.getCheckInDate())));
            }

            if (Objects.nonNull(dto.getCustomerName())) {
                predicates.add(criteriaBuilder.and(criteriaBuilder.like(getCustomerJoin(root).get("name"), "%"+dto.getCustomerName()+"%")));
            }

            customerJoin = null;

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }, PageRequest.of(0, 10));

        return reservationMapper.toDTOList(page.getContent());
    }

}
