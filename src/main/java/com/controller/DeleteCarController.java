package com.controller;


import com.service.DeleteCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/delete")
public class DeleteCarController {
    @Autowired
    private DeleteCarService deleteCarService;
    @RequestMapping(value = "/Car", method = RequestMethod.POST)
    public Map<String, Object> addBuyCar(HttpSession session, @RequestBody Map<String, Object> map) {
        String buyuser_name = (String)(session.getAttribute("user_name"));
        String buycard_name = (String)(map.get("buycard_name"));
        deleteCarService.delete_car(buyuser_name, buycard_name);
        Map<String, Object> ma = new HashMap();
        map.put("deleteInfo","yes");
        return map;
    }
}
