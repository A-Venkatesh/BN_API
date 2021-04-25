package com.konda.baskinnature.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Document("promo")
public class Promo {
    @Id
    private String id = "Promos";
    private ArrayList<HashMap<String, String>> variants = new ArrayList<>();
}
