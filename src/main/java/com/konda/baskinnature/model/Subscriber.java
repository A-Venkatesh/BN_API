package com.konda.baskinnature.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.nio.ByteBuffer;
import java.util.UUID;

import static java.lang.Character.MAX_RADIX;
@Data
@Document("Subscriber")
public class Subscriber {
     private String id = Long.toString(ByteBuffer.wrap(UUID.randomUUID().toString().getBytes()).getLong(), MAX_RADIX);
     private String email;
     private String name;
     private boolean subscribed = true;
}
