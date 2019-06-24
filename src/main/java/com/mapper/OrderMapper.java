package com.mapper;

import com.pojo.Order1;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    List<Order1> show_order();
}

