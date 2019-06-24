package com.service.impl;

import com.mapper.OrderMapper;
import com.pojo.Order1;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public List<Order1> show_order() {
         return (orderMapper.show_order());
    }
}

