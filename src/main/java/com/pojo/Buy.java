package com.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Buy {
    private String buyuser_name;
    private String buycard_name;
    private BigDecimal buycard_price;
    private BigDecimal buycard_singleprice;
    private int buycard_number;
    private String buycard_state;
}

