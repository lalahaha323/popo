package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int login(@Param("user_name") String user_name, @Param("user_password") String user_password);
    int register(@Param("user_name") String user_name, @Param("user_password") String user_password, @Param("user_email") String user_email);
    String forget(@Param("user_name") String user_name);
    int modify(@Param("user_name") String user_name, @Param("user_password") String user_password);
}
