package com.konda.baskinnature.service.implementations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component("javaMailSender")

public class MailService {
    @Autowired
    JavaMailSender javaMailSender;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendMail(String from, String to, String subject, String body) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setText(body, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        logger.info("Sending...");
        javaMailSender.send(mimeMessage);
        logger.info("Done!");
    }

}
