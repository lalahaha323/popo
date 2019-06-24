package com.service.impl;


import com.mapper.MailMapper;
import com.service.MailService;
import com.util.RandomSecurityCode;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mailService")
public class MailServiceImpl implements MailService {
    @Autowired
    private MailMapper mailMapper;
    public int checkMail(String user_email) {
        return (mailMapper.checkMail(user_email));
    }
    public String sendMail(String user_email) {
        SimpleEmail email = new SimpleEmail();
        try {
            email.setHostName("smtp.qq.com");
            email.setCharset("utf-8");
            //收件人
            email.addTo(user_email);
            email.setFrom("2665687186@qq.com", "小恐龙甜品店");
            //需要认证信息,用户名,密码(授权码)
            email.setAuthentication("2665687186@qq.com", "mddnittagwwlecfd");
            email.setSSLOnConnect(true);
            String securityCode = RandomSecurityCode.getCode();
            email.setSubject("注册验证码");
            email.setMsg("尊敬的用户您好!\n注册验证码为:" + securityCode + "\n");
            email.send();
            return securityCode;
        } catch (Exception exception) {
            exception.printStackTrace();
            return "no";
        }

    }
    public String sendHostEmail(String user_name,String user_email,String user_subject,String user_message) {
        SimpleEmail email = new SimpleEmail();
        try {
            email.setHostName("smtp.qq.com");
            email.setCharset("utf-8");
            //收件人
            email.addTo("2665687186@qq.com");
            email.setFrom(user_email, "顾客回执单");
            //需要认证信息,用户名,密码(授权码)
            email.setAuthentication(user_email, "vsvcfuhvaqmydcjh");
            email.setSSLOnConnect(true);
            email.setSubject(user_subject);
            email.setMsg(user_message);
            email.send();
            return "yes";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "no";
        }
    }
}
