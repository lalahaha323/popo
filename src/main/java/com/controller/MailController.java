package com.controller;

import com.service.MailService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> registerCodeMail (HttpSession session, @RequestBody Map<String, String> map) {
        String msg;
        Map<String, Object> ma = new HashMap();
        int flag = mailService.checkMail(map.get("user_email"));
        if(flag == 1) {
            //邮箱重复了,注册失败
            ma.put("mailInfo", "no");
        } else {
            //发送邮箱验证码
            msg = mailService.sendMail(map.get("user_email"));
            if(msg == "no") {
                ma.put("mailInfo", "no");
            } else {
                ma.put("mailInfo", "yes");
                session.setAttribute("securityCode", msg);
            }
        }
        return ma;
    }
    @RequestMapping(value="/send", method=RequestMethod.POST)
    public Map<String, String> sendEmail(@RequestBody Map<String, String> map) {
        String user_name = map.get("user_name");
        String user_email = map.get("user_email");
        String user_subject = map.get("user_subject");
        String user_message = map.get("user_message");
        String msg = mailService.sendHostEmail(user_name, user_email, user_subject, user_message);
        Map<String, String> ma = new HashMap();
        ma.put("msg", msg);
        return ma;
    }
}
