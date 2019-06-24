package com.pojo;

import lombok.Data;

@Data
public class User {
    private int user_id;
    private String user_name;
    private String user_password;
    private String user_email;
    private String user_securityCode;
}
