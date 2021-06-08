package com.konda.baskinnature.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import static java.lang.Character.MAX_RADIX;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Document("order")
public class Order {
    @Id
    private String id;
    private HashMap<String, String> invoice;
    private ArrayList<HashMap<String, String>> line_items = new ArrayList<>();
    private ArrayList<HashMap<String, String>> stockObject = new ArrayList<>();
    private HashMap<String, String> shippingAddress;
    private HashMap<String, String> userDetails;
    private String razorpay_payment_id;
    private HashMap<String, String> data;
    private String method;
    private int shippingFees;
    private String userId;
    private Status status;
    private String awb;
    private String courierName;
    private String coupon = null;
    private boolean couponApplied = false;
    private float discountedPrice;
    private Date postedOn = new Date();
    private String mode = "internal";
}
