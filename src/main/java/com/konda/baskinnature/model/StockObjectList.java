package com.konda.baskinnature.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StockObjectList implements Serializable {
    private List<StockObject> stockObjects;
}
