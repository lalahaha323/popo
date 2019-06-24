package com.controller;


import com.pojo.Order1;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.System.out;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping(value="/order", method= RequestMethod.POST)
    public List<Order1> order_bread() {
        return orderService.show_order();
    }
}
