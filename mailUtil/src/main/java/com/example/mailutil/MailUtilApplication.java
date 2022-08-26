package com.example.mailutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailUtilApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MailUtilApplication.class, args);

        SendingMail.sendMail("bulutruzgaremir@gmail.com");
    }



}
