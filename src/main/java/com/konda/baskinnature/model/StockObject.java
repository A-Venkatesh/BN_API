package com.konda.baskinnature.model;

import lombok.Data;
import java.io.Serializable;

@Data
public class StockObject implements Serializable {
    private static final long serialVersionUID = 1L;
    String quantity;
    String id;
    String categoryId;
}
