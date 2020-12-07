package com.zh.courseDesign.web.servlet;

import com.zh.courseDesign.web.bean.User;
import com.zh.courseDesign.web.dao.bean.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.security.spec.ECField;
import java.util.List;

/**
 * @author MaCode
 * @date 2020-12-04
 * @github HappyOnion801
 */
@WebServlet(name = "user")
public class user extends HttpServlet {
    private String add(HttpServletRequest request) {
        String message = "{\"code\":\"0\"}";
        try {
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            if (name == null || password == null)
                return message;
            User user = new User(name, password, 2);
            UserDAO userDAO = new UserDAO();
            if (userDAO.UserExists(name))
                return "{\"code\":\"-1\"}";
            int count = userDAO.userAdd(user);
            if (count == 1)
                message = "{\"code\":\"1\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    private String delete(HttpServletRequest request) {
        String message = "{\"code\":\"0\"}";
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (id <= 0) {
                return message;
            }
            UserDAO userDAO = new UserDAO();
            boolean flag = userDAO.userDelete(id);
            if (flag)
                message = "{\"code\":\"1\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    private String update(HttpServletRequest request) {
        String message = "{\"code\":\"0\"}";
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String password = request.getParameter("password");
            if (password == null || id <= 0) {
                return message;
            }
            UserDAO userDAO = new UserDAO();
            User user = userDAO.userDisplay(id);
            User u = new User(id, user.getName(), password, user.getType());
            boolean flag = userDAO.userUpdate(u);
            if (flag)
                message = "{\"code\":\"1\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    private String page(HttpServletRequest request) {
        String message = "{\"code\":\"0\"}";
        try {
            int type = Integer.parseInt(request.getParameter("type"));
            int page = Integer.parseInt(request.getParameter("page"));
            String name = request.getParameter("name");
            if (page < 1)
                return message;
            StringBuilder sb = new StringBuilder("[");
            UserDAO userDAO = new UserDAO();
            List<User> res = null;
            res = userDAO.userList(type,name,page);
            for (int i = 0; i < res.size(); i++) {
                if (i != 0)
                    sb.append(",");
                sb.append(res.get(i));
            }
            sb.append("]");
            message = "{\"code\":\"1\",\"list\":" + sb.toString() + "}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    private String count(HttpServletRequest request) {
        String message = "{\"code\":\"0\"}";
        try {
            int type = Integer.parseInt(request.getParameter("type"));
            String name = request.getParameter("name");
            UserDAO userDAO = new UserDAO();
            int res = -1;
            res = userDAO.count(type,name);
            message = "{\"code\":\"1\",\"all\":\"" + res + "\",\"limit\":\"" + userDAO.getLimit() + "\"}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String message = "{\"code\":\"0\"}";
        OutputStream os = response.getOutputStream();
        try {
            String operation = request.getParameter("operation");
            if ("add".equals(operation)) {
                message = add(request);
            } else if ("delete".equals(operation)) {
                message = delete(request);
            } else if ("update".equals(operation)) {
                message = update(request);
            } else if ("page".equals(operation)) {
                message = page(request);
            } else if ("count".equals(operation)) {
                message = count(request);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.write(message.getBytes());
                os.close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
