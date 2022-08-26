package com.example.hotels.repository;

import com.example.hotels.dto.RoomDTO;
import com.example.hotels.entity.Reservation;
import com.sun.istack.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Optional<Reservation> findById(int id);

    Page<Reservation> findAll(@Nullable Specification productSpecification, Pageable pageable);

    List<Reservation> findAllByCheckInDateBetween(Date checkInDate, Date checkInDate2);

   boolean existsByRoom_IdAndCheckInDateBetween(int id, Date checkInDate, Date checkOutDate);

   @Query(nativeQuery = true,
           value = "select * from reservations r\n" +
           "where room_id = ?1\n" +
           "  and (check_in_date between ?2 and ?3\n" +
           "        or check_out_date between ?2 and ?3\n" +
           "        or ?2 between check_in_date and check_out_date\n" +
           "        or ?3 between check_in_date and check_out_date)")
   List<Reservation> findAllByAvailablePeriod(int roomId, Date cin, Date cout);

}
