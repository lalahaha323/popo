package com.service;

import com.pojo.User;

public interface UserService {
    int login(String user_name, String user_password);
    int register(String user_name, String user_password, String user_email);
    String forget(String user_name);
    int modify(String user_name, String user_password);
}
