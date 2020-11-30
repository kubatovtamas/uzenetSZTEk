package com.uzenetesztek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;
    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }



    @Value("${spring.mail.username}")
    private String MESSAGE_FROM;

    @Value("${EmailService.url}") //in the application-dev.properties. Currently it is localhost:8080/ TODO: update this when deployed
    private String URL;

    public void sendMessage(String email, String firstName, String activationCode) {
        SimpleMailMessage message = null;

        try {
            message = new SimpleMailMessage();
            message.setFrom(MESSAGE_FROM);
            message.setTo(email);
            message.setSubject("Account activation");
            message.setText("Dear " + firstName + "!\n\n" + "Click the link to activate your account: " + URL + activationCode);
            javaMailSender.send(message);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
