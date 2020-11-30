package com.zh.courseDesign.web;

import com.zh.courseDesign.web.bean.TestBean;
import com.zh.courseDesign.web.bean.User;
import com.zh.courseDesign.web.dao.bean.UserDAO;
import com.zh.courseDesign.web.dao.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author MaCode
 * @date 2020-11-29
 * @github HappyOnion801
 */
public class TestUnit {

    @Test
    public void field(){
        try {
            Field f = User.class.getDeclaredField("id");
            System.out.println(f);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getConnection() {
        System.out.println(JDBCUtils.getConnection());
    }

    @Test
    public void userAllCount() {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.userAllCount());
    }

    @Test
    public void userDeleteById() {
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.userDelete(2));
    }

    @Test
    public void userAdd() {
        UserDAO userDAO = new UserDAO();
        int res = userDAO.userAdd(new User("zhanghao", "pwd", 1, "2020-01-01"));
        System.out.println(res);
    }

    @Test
    public void userUpdate() {
        UserDAO userDAO = new UserDAO();
        boolean res = userDAO.userUpdate(new User(6, "zhanghao", "pwd", 1, "2025-01-01"));
        System.out.println(res);
    }

    @Test
    public void userList() {
        UserDAO userDAO = new UserDAO();
        List<User> res = userDAO.userList(2);
        for (Object b : res) {
            System.out.println(b);
        }
    }
}
