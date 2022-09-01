package com.example.hotels.client;

import com.example.hotels.dto.MailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "hotels-mail", url = "http://localhost:8085/api/mail")
public interface MailClient {

    @PostMapping ("/main/send")
    void sendMail(MailDTO mailDTO);

}
