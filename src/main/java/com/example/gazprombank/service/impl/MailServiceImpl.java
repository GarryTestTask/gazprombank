package com.example.gazprombank.service.impl;

import com.example.gazprombank.service.MailService;
import com.example.gazprombank.service.RecipientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MailServiceImpl implements MailService {

    final JavaMailSender javaMailSender;
    final RecipientService recipientService;

    @Value("${spring.mail.username}")
    String sender;

    @Override
    @Scheduled(cron = "0 0 17 * * MON-FRI")
    public void send() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(recipientService.getAddresses().toArray(new String[0]));
        mailMessage.setText("Пора пить чай");
        mailMessage.setSubject("Напоминание");
        javaMailSender.send(mailMessage);
    }

}
