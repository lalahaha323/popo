package com.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MailMapper {
    int checkMail(@Param("user_email") String user_email);
}

