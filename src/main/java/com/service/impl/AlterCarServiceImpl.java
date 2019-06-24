package com.service.impl;

import com.mapper.AlterCarMapper;
import com.service.AlterCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service("alterCarService")
public class AlterCarServiceImpl implements AlterCarService {
    @Autowired
    AlterCarMapper alterCarMapper;
    public int alter_car(String buyuser_name, String buycard_name, int buycard_number,  BigDecimal buycard_price){
        return alterCarMapper.alter_car(buyuser_name, buycard_name, buycard_number, buycard_price);
    }
}
