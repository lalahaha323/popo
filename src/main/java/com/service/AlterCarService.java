package com.service;

import java.math.BigDecimal;

public interface AlterCarService {
    int alter_car(String buyuser_name, String buycard_name, int buycard_number,  BigDecimal buycard_price);
}
