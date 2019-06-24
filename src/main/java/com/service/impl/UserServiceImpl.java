package com.service.impl;

import com.mapper.UserMapper;
import com.pojo.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//用来将当前类注释为一个Spring的bean,名为userService
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    //自动注入UserMapper
    private UserMapper userMapper;

    public int login(String user_name, String user_password){
        return (userMapper.login(user_name, user_password));
    }

    public int register(String user_name, String user_password, String user_email) {
        return (userMapper.register(user_name, user_password, user_email));
    }

    public String forget(String user_name) {
        return (userMapper.forget(user_name));
    }

    public int modify(String user_name, String user_password) {
        return (userMapper.modify(user_name, user_password));
    }
}
