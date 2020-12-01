package com.zh.courseDesign.web.Test;

import com.zh.courseDesign.web.bean.User;
import com.zh.courseDesign.web.dao.bean.UserDAO;
import org.junit.Test;

import java.util.List;

/**
 * @author MaCode
 * @date 2020-11-29
 * @github HappyOnion801
 */
public class TestUserDAO {

    @Test
    public void userAllCount() {
        System.out.print("获取所有的用户数量：");
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.userAllCount());
    }

    @Test
    public void userDeleteById() {
        System.out.print("通过id删除用户：");
        UserDAO userDAO = new UserDAO();
        System.out.println(userDAO.userDelete(2));
    }

    @Test
    public void userAdd() {
        System.out.print("添加用户：");
        UserDAO userDAO = new UserDAO();
        int res = userDAO.userAdd(new User("zhanghao", "pwd", 1, "2020-01-01"));
        System.out.println(res);
    }

    @Test
    public void userUpdate() {
        System.out.print("更新用户信息：");
        UserDAO userDAO = new UserDAO();
        boolean res = userDAO.userUpdate(new User(6, "zhanghao", "pwd", 1, "2025-01-01"));
        System.out.println(res);
    }

    @Test
    public void userList() {
        System.out.println("获取用户列表：");
        UserDAO userDAO = new UserDAO();
        List<User> res = userDAO.userList(1);
        for (Object b : res) {
            System.out.println(((User)b).toJson());
        }
    }

}
