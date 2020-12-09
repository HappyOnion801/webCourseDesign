package com.zh.courseDesign.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MaCode
 * @date 2020-12-09
 * @github HappyOnion801
 */
public class logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("userID",null);
        Cookie cookie = new Cookie("userID",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.getOutputStream().write("{\"code\":\"1\"}".getBytes());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
