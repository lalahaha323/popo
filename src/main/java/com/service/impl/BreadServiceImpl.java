package com.service.impl;

import com.mapper.BreadMapper;
import com.pojo.Bread;
import com.service.BreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("breadService")
public class BreadServiceImpl implements BreadService {
    @Autowired
    private BreadMapper breadMapper;
    public List<Bread> showBread() {
        return(breadMapper.showBread());
    }
}
