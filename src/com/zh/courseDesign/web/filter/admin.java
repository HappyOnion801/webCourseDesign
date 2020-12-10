package com.zh.courseDesign.web.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

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
        if (request.getSession().getAttribute("userID") != null)
            chain.doFilter(req, resp);
        else
            ((HttpServletResponse) resp).sendRedirect("login.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
