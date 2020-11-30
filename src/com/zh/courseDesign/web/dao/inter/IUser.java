package com.zh.courseDesign.web.dao.inter;

import com.zh.courseDesign.web.bean.User;

import java.util.List;

/**
 * @author MaCode
 * @date 2020-11-30
 * @github HappyOnion801
 */
public interface IUser {
    public List<User> userList(int page);
    public List<User> userAdminList(int page);
    public List<User> userNormalList(int page);
    public User userDisplay(int id);
    public User userDisplay(String name,String pwd);
    public User userDisplay(String name);
    public boolean UserExists(String name);
    public int userAdd(User user);
    public boolean userDelete(int id);
    public boolean userUpdate(User user);
    public int userAllCount();
    public int userAdminCount();
    public int userNormalCount();
}
