package com.example.hotels.controller;

import com.example.hotels.dto.MailDTO;
import com.example.hotels.service.mailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/main")
public class MailController {

    @PostMapping("/send")
    public void sendMail(@RequestBody MailDTO mailDTO) {
        mailService.sendMail(mailDTO);
    }

}
