package com.zh.courseDesign.web.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        HttpSession session = request.getSession();
        if (session.getAttribute("userID") != null) {
            flag = true;
        }
        if (!flag) {
            ((HttpServletResponse) resp).sendRedirect("../login.jsp");
            System.out.println("拦截成功！");
        } else {
            System.out.println(session.getAttribute("userID") + "登录成功！");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
