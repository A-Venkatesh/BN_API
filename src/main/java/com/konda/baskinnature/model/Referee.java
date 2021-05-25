package com.konda.baskinnature.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Document("referee")
@Data
public class Referee {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private int totalSales =0;
    private float percentage =10;
    private ArrayList<String> orders;
}
