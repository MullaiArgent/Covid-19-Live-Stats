package com.springproject.Covid19Stats.appuser.email;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
//import org.springframework.mail.javamail.JavaMailSender;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender{


    @Override
    public void send(String To, String email) {

    }
}
