package com.filter;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class LoginFilter implements Filter {
    public void destroy() {

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)arg0;
        HttpServletResponse response = (HttpServletResponse)arg1;
        HttpSession session = request.getSession();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        Map<String, String> map = new HashMap();
        if(request.getRequestURI().equals("/popo_war_exploded/user/login")  || request.getRequestURI().equals("/popo_war_exploded/user/register") || request.getRequestURI().equals("/popo_war_exploded/mail/register") ) {
        } else if(session.getAttribute("loginInfo") == null || ((String)(request.getParameter("loginInfo"))).equals("no")){
            //返回一个json,说没有登录
            ObjectMapper mapper = new ObjectMapper();
            map.put("FilterInfo", "no");
            //User类转JSON
            //输出结果：{"name":"zhangsan","age":20,"birthday":844099200000,"email":"zhangsan@163.com"}
            String json = mapper.writeValueAsString(map);
            response.getWriter().write(json);
            return;
        } else {
        }
        filterChain.doFilter(request, response);
    }

    public void init(FilterConfig arg0) throws ServletException {

    }
}
