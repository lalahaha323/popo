package com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteCarMapper {
    int delete_car(@Param("buyuser_name") String buyuser_name, @Param("buycard_name") String buycard_name);
}
