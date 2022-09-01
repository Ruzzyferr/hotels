package com.example.hotels.service;

import com.example.hotels.dto.MailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
@Service
@FeignClient(value = "hotels-mail", url = "http://localhost:8085")
public interface mailService {

    @GetMapping("/main/send")
    public static void sendMail(MailDTO mailDTO) {

    }

}
