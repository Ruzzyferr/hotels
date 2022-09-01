package com.example.hotels.service;

import com.example.hotels.client.MailClient;
import com.example.hotels.dto.MailDTO;
import com.example.hotels.entity.Customer;
import com.example.hotels.entity.Reservation;
import com.example.hotels.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ScheduledJobs {

    private final ReservationRepository reservationRepository;
    private final MailClient mailClient;

    @Scheduled(cron = "0 * * * * *")
    public void ScheduledMail(){
        Date t = new Date();
        t.getTime();
        DateTime today = new DateTime(t);
        DateTime plusThree = today.plusDays(4);


        List <Reservation> sendAnEmail = reservationRepository.findAllByCheckInDateBetween(t,plusThree.toDate());
        for(Reservation reservation : sendAnEmail ){
            Set<Customer> set = reservation.getCustomer();
            Date checkIn = reservation.getCheckInDate();
            for( Customer customer : set) {
                String message = "Sayın " + customer.getName() + " check in tarihinize " + calculateRemainingDayCount(checkIn) + " gün(ler) kalmıştır.";
                MailDTO mailDTO = MailDTO.builder()
                        .to(customer.getEmail())
                        .subject("Check-In Tarihiniz yaklaşıyor")
                        .context(message)
                        .build();
                mailClient.sendMail(mailDTO);
            }
        }


    }

    private int calculateRemainingDayCount(Date checkIn) {
        Date today = new Date();
        long diff = checkIn.getTime() - today.getTime();
        return (int) (diff / (1000*60*60*24));
    }


}
