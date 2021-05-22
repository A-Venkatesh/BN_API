package com.konda.baskinnature;

import com.konda.baskinnature.service.implementations.MailService;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.mail.MailSender;

import javax.mail.MessagingException;

@SpringBootApplication
public class BaskinnatureApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaskinnatureApplication.class, args);
    }

}
