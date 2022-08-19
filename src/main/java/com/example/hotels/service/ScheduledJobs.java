/*package com.example.hotels.service;

import com.example.hotels.dto.CustomerDTO;
import com.example.hotels.entity.Reservation;
import com.example.hotels.repository.ReservationRepository;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ScheduledJobs {

    ReservationRepository reservationRepository;

    @Scheduled(cron = "5 * * * * *")
    public void ScheduledMail(){
        Date t = new Date();
        DateTime today = new DateTime(t);
        DateTime plusThree = today.plusDays(4);


        List <Reservation> sendAnEmail = reservationRepository.findAllByCheckInDateBetween(today.toDate(),plusThree.toDate());
        for(Reservation reservation : sendAnEmail ){
            CustomerDTO customerDTO = (CustomerDTO) reservation.getCustomer();
            Date checkIn = reservation.getCheckInDate();
            DateTime checkInDate = new DateTime(checkIn);

            if (today.plusDays(3).toDate() == checkInDate.toDate()){
                System.out.println("Sayın"+ customerDTO.getName() + "Check in tarihinize 3 gün kalmıştır");
            }else if (today.plusDays(2).toDate() == checkInDate.toDate()){
                System.out.println("Sayın"+ customerDTO.getName() + "Check in tarihinize 2 gün kalmıştır");
            }else if (today.plusDays(1).toDate() == checkInDate.toDate()){
                System.out.println("Sayın"+ customerDTO.getName() + "Check in tarihinize 1 gün kalmıştır");
            }else if (today.toDate() == checkInDate.toDate()){
                System.out.println("Sayın"+ customerDTO.getName() + "Check in tarihiniz bugündür");
            }
        }


    }


}*/
