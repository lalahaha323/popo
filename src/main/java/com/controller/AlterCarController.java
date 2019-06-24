package com.controller;

import com.service.AlterCarService;
import com.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/alter")
public class AlterCarController {
    @Autowired
    private AlterCarService alterCarService;
    @Autowired
    private BuyService buyService;
    @RequestMapping(value="/Car" , method = RequestMethod.POST)
    public Map<String, Object> altercar(HttpSession session, @RequestBody Map<String, Object> map) {
        String buyuser_name = (String)(session.getAttribute("user_name"));
        String buycard_name = (String)(map.get("buycard_name"));
        int buycard_number = Integer.parseInt(map.get("buycard_number").toString());
        //查询数据库中商品的单价
        BigDecimal buycard_singleprice = buyService.selectprice(buycard_name);
        //手动计算总共的价钱
        BigDecimal price = (buycard_singleprice).multiply(BigDecimal.valueOf(buycard_number));
        BigDecimal buycard_price = price.setScale(2,BigDecimal.ROUND_HALF_UP);
        alterCarService.alter_car(buyuser_name, buycard_name, buycard_number, buycard_price);
        Map<String, Object> ma = new HashMap();
        ma.put("alterCarInfo", "yes");
        return ma;
    }
}
