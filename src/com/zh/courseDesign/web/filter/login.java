package com.zh.courseDesign.web.filter;

import com.zh.courseDesign.web.service.CookieServer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author MaCode
 * @date 2020-12-09
 * @github HappyOnion801
 */
public class login implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies)
            if ("userID".equals(c.getName()))
                request.getSession().setAttribute("userID", CookieServer.getUser(c.getValue()));
        if (request.getSession().getAttribute("userID") != null)
            response.sendRedirect("admin.html");
        else
            chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
