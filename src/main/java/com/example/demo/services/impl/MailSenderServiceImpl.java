package com.example.demo.services.impl;

import com.example.demo.services.MailSenderService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
@Service
public class MailSenderServiceImpl implements MailSenderService {
    private final JavaMailSender mailSender;

    public MailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override

    public void sendMail(String email, String url, String msgText) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("noreply@baeldung.com");
        helper.setTo(email);
        helper.setText(msgText);
        helper.setSubject("Your order");
        FileSystemResource file
                = new FileSystemResource(new File(url));
        helper.addAttachment(file.getFilename(), file);
        mailSender.send(message);

    }
}
