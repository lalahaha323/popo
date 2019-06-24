package com.service;

public interface MailService {
    int checkMail(String user_email);
    String sendMail(String user_email);
    String sendHostEmail(String user_name, String user_email,String user_subject,String user_message);
}
