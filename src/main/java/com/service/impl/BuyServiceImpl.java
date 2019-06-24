package com.service.impl;

import com.mapper.BuyMapper;
import com.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("buyService")
public class BuyServiceImpl implements BuyService {
    @Autowired
    private BuyMapper buyMapper;
    public int addCar(String buyuser_name, String buycard_name, BigDecimal buycard_price, BigDecimal buycard_singleprice, int buycard_number, String buycard_state){
        return buyMapper.addCar(buyuser_name, buycard_name, buycard_price, buycard_singleprice, buycard_number, buycard_state);
    }
    public BigDecimal selectprice(String buycard_name) {
        return buyMapper.selectPrice(buycard_name);
    }
}
