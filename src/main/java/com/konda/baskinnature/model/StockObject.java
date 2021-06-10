package com.konda.baskinnature.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class StockObject implements Serializable {
    private static final long serialVersionUID = 1L;
    int quantity;
    String id;
    String categoryId;
}
