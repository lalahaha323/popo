package com.controller;

import com.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buycar")
public class BuyController {
    @Autowired
    private BuyService buyService;
    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    public Map<String, Object> addBuyCar(HttpSession session, @RequestBody Map<String, Object> map) {
        String buyuser_name = (String)(session.getAttribute("user_name"));
        String buycard_name = (String)(map.get("buycard_name"));
        int buycard_number = Integer.parseInt(map.get("buycard_number").toString());
        //查询数据库中商品的单价
        BigDecimal buycard_singleprice = buyService.selectprice(buycard_name);
        //手动计算总共的价钱
        BigDecimal price = (buycard_singleprice).multiply(BigDecimal.valueOf(buycard_number));
        BigDecimal buycard_price = price.setScale(2,BigDecimal.ROUND_HALF_UP);
        String buycard_state = "加入购物车";
        int flag = buyService.addCar(buyuser_name, buycard_name, buycard_price, buycard_singleprice, buycard_number ,buycard_state);
        Map<String, Object> ma = new HashMap();
        ma.put("addCarInfo", "yes");
        return ma;
    }
}
