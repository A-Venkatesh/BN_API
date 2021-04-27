package com.konda.baskinnature;

import com.mongodb.client.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class BaskinnatureApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaskinnatureApplication.class, args);
	}

}
