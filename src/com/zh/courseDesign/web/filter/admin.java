package com.zh.courseDesign.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MaCode
 * @date 2020-12-03
 * @github HappyOnion801
 */
public class admin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        for(Cookie c:cookies){
            if("userID".equals(c.getName())){
                System.out.println("欢迎：" + c.getValue());
                flag = true;
                break;
            }
        }
        if(!flag){
            ((HttpServletResponse)resp).sendRedirect("../login.jsp");
            System.out.println("拦截成功！");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
