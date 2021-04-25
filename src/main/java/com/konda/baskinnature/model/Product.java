package com.konda.baskinnature.model;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("product")
public class Product {

    @Id
    @Indexed
    private String id = Long.toString(ByteBuffer.wrap(UUID.randomUUID().toString().getBytes()).getLong(), Character.MAX_RADIX);
    private String title;
    private String description;
    private float price;
    private String image;
    private int rating;
    private int stockInUnits;
    private Boolean published = true;
    private Boolean featured = false;
    private String slug;
    private String categoryId;
    private String genre;

    private ArrayList<HashMap<String, String>> types = new ArrayList<>();
    private ArrayList<HashMap<String, String>> variants = new ArrayList<>();
}
