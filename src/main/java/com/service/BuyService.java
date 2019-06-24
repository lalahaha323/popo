package com.service;

import java.math.BigDecimal;

public interface BuyService {
    int addCar(String buyuser_name, String buycard_name, BigDecimal buycard_price, BigDecimal buycard_singleprice, int buycard_number, String buycard_state);
    BigDecimal selectprice(String buycard_name);
}
