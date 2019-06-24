package com.controller;

import com.pojo.User;
import com.service.MailService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private MailService mailService;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, String> register(HttpSession session, @RequestBody Map<String, String> map) {
        Map ma = new HashMap();
        if((map.get("user_securityCode")).equals((String)(session.getAttribute("securityCode")))) {
            //验证码正确,可以插入了
            try {
                System.out.println(map.get("user_securityCode") + map.get("user_name"));
                userService.register(map.get("user_name"), map.get("user_password"), map.get("user_email"));
                ma.put("registerInfo", "yes");
                ma.put("msg", "注册成功");
            } catch (Exception exception) {
                ma.put("registerInfo", "no");
                ma.put("msg", "注册失败");
            }
        } else {
            ma.put("registerInfo", "no");
            ma.put("msg", "验证码错误");
        }
        return ma;
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Map<String, String> login(HttpSession session, @RequestBody Map<String, String> map) {
        Map ma = new HashMap();
        int flag = userService.login(map.get("user_name"), map.get("user_password"));
        if(flag == 1) {
            //登陆成功
            ma.put("loginInfo", "yes");
            ma.put("msg", "登陆成功");
            session.setAttribute("user_name", map.get("user_name"));
        } else {
            //登录失败
            ma.put("loginInfo", "no");
            ma.put("msg", "登录失败");
        }
        return ma;
    }
    @RequestMapping(value="/forget", method=RequestMethod.POST)
    public Map<String, String> forget(HttpSession session, @RequestBody Map<String, String> map) {
        Map ma = new HashMap();
        String msg = mailService.sendMail(userService.forget(map.get("user_name")));
        if(msg == "no") {
            ma.put("mailInfo", "no");
        } else {
            ma.put("mailInfo", "yes");
            session.setAttribute("securityCode", msg);
        }
        return ma;
    }
    @RequestMapping(value="/forget/modify", method = RequestMethod.POST)
    public Map<String, String> modify(HttpSession session, @RequestBody Map<String, String> map) {
        Map ma = new HashMap();
        if((map.get("user_securityCode")).equals((String)(session.getAttribute("securityCode")))) {
            //说明验证码是正确的
            int flag = userService.modify(map.get("user_name"), map.get("user_password"));
            if(flag == 0) {
                //更新失败
                ma.put("modifyInfo", "修改失败");
            } else {
                ma.put("modifyInfo", "修改成功");
            }
        } else {
            //验证码错误
            ma.put("modifyInfo", "验证码错误");
        }
        return ma;
    }
}
