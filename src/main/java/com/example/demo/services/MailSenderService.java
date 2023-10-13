package com.example.demo.services;

import javax.mail.MessagingException;

public interface MailSenderService {
    public void sendMail(String email, String url, String msgText) throws MessagingException;
}
