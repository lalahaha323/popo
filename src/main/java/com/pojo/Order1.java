package com.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order1 {
    private String order_name;
    private int order_number;
    private BigDecimal order_singleprice;
    private String order_describe;
    private String order_url;
}
