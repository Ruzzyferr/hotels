package com.example.mailutil;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendingMail {

    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send mail");
        Properties properties = new Properties();

        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");

        properties.put("mail.smtp.pool",true);
        properties.put("mail.smtp.max-connections",10);
        properties.put("mail.smtp.max-messages",200);
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.starttls.required",true);
        properties.put("mail.smtp.ssl.enable",true);

        String hostAcc = "hotelkafein@hotmail.com";
        String pass = "stajKafein34";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(hostAcc,pass);
            }
        });

        Message message = prepareMessage(session,hostAcc, recepient);
        Transport.send(message);
        System.out.println("Mail sent succesfully");

    }

    private static Message prepareMessage(Session session, String hostAcc, String recepient){
        Message message =  new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(hostAcc));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("My first email from Java");
            message.setText("Hey Rüzgar \n here is your first mail!!");
            return message;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
