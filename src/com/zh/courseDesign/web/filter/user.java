package com.zh.courseDesign.web.filter;

import org.junit.runner.Request;

import javax.jms.Session;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author MaCode
 * @date 2020-12-09
 * @github HappyOnion801
 */
public class user implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        OutputStream os = response.getOutputStream();
        if (request.getSession().getAttribute("userID") != null)
            chain.doFilter(req, resp);
        else
            os.write("{\"code\":\"0\",\"msg\":\"Filter\"}".getBytes());
        os.close();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
