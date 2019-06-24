package com.service.impl;

import com.mapper.DeleteCarMapper;
import com.service.DeleteCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deleteCarService")
public class DeleteCarServiceImpl implements DeleteCarService {
    @Autowired
    private DeleteCarMapper deleteCarMapper;
    public int delete_car(String buyuser_name, String buycard_name){
        return deleteCarMapper.delete_car(buyuser_name, buycard_name);
    }
}
