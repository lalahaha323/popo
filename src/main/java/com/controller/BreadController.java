package com.controller;

import com.pojo.Bread;
import com.service.BreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buybread")
public class BreadController {
    @Autowired
    private BreadService breadService;
    @RequestMapping(value = "/show", method = RequestMethod.POST)
    public List<Bread> showBread() {
        return breadService.showBread();
    }

}
