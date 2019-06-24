package com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BuyMapper {
    int addCar(@Param("buyuser_name") String buyuser_name, @Param("buycard_name") String buycard_name, @Param("buycard_price") BigDecimal buycard_price, @Param("buycard_singleprice") BigDecimal buycard_singleprice, @Param("buycard_number") int buycard_number, @Param("buycard_state") String buycard_state);
    BigDecimal selectPrice(@Param("buycard_name") String buycard_name);
}
