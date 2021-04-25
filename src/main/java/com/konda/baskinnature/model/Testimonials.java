package com.konda.baskinnature.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.UUID;

import static java.lang.Character.MAX_RADIX;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Testimonials")
public class Testimonials {

    @Id
    private String id = Long.toString(ByteBuffer.wrap(UUID.randomUUID().toString().getBytes()).getLong(), MAX_RADIX);

    private String name;
    private String content;
    private String title;
    private String image;
    private Date postedOn = new Date();
    private Boolean approved = false;

}
