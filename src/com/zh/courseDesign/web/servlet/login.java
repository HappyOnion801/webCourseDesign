package com.zh.courseDesign.web.servlet;

import com.zh.courseDesign.web.bean.User;
import com.zh.courseDesign.web.dao.bean.UserDAO;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author MaCode
 * @date 2020-12-03
 * @github HappyOnion801
 */
public class login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        OutputStream os = response.getOutputStream();
        String message = "{\"code\":0}";
        try {
            String password = request.getParameter("password");
            String username = request.getParameter("username");
            String remind = request.getParameter("remind");
            UserDAO userDAO = new UserDAO();
            User user = userDAO.userDisplay(username);
            if (user != null && password.equals(user.getPwd())) {
                Cookie cookie = new Cookie("userID", String.valueOf(user.getId()));
                cookie.setMaxAge(30);
                if ("remind".equals(remind)) cookie.setMaxAge(604800);
                response.addCookie(cookie);
                message = "{\"code\":1,\"user\":\"" + user.getId() + "\"}";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println(message);
            os.write(message.getBytes());
            os.close();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request, response);
    }
}
