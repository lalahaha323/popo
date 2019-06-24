package com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AlterCarMapper {
    int alter_car(@Param("buyuser_name") String buyuser_name, @Param("buycard_name") String buycard_name, @Param("buycard_number") int buycard_number, @Param("buycard_price") BigDecimal buycard_price);
}
