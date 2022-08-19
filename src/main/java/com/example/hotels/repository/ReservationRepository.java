package com.example.hotels.repository;

import com.example.hotels.dto.RoomDTO;
import com.example.hotels.entity.Reservation;
import com.sun.istack.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Optional<Reservation> findById(int id);

    Page<Reservation> findAll(@Nullable Specification productSpecification, Pageable pageable);

    List<Reservation> findAllByCheckInDateBetween(Date checkInDate, Date checkInDate2);

   Reservation findByRoom(RoomDTO room);

}
