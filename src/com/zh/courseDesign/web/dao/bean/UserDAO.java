package com.zh.courseDesign.web.dao.bean;

import com.zh.courseDesign.web.bean.User;
import com.zh.courseDesign.web.dao.BaseDAO;
import com.zh.courseDesign.web.dao.inter.IUser;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * @author MaCode
 * @date 2020-11-30
 * @github HappyOnion801
 */
public class UserDAO extends BaseDAO<User> implements IUser {

    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(UserDAO.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLimit() {
        return Integer.parseInt(properties.getProperty("limit"));
    }

    @Override
    public List<User> userList(int page) {
        int limit = getLimit();
        return super.select("select * from user limit ?,?", (page - 1) * limit, limit);
    }

    @Override
    public List<User> userAdminList(int page) {
        int limit = getLimit();
        return super.select("select * from user where type=? limit ?,?", User.ADMIN, (page - 1) * limit, limit);
    }

    @Override
    public List<User> userNormalList(int page) {
        int limit = getLimit();
        return super.select("select * from user where type=? limit ?,?", User.NORMAL, (page - 1) * limit, limit);
    }

    @Override
    public User userDisplay(int id) {
        List<User> res = super.select("select * from user where id=?", id);
        if (res != null && res.size() == 1) return res.get(0);
        return null;
    }

    /**
     * 通过用户名和密码来进行用户的搜索，但是因为用户名可能存在重复问题所以该方法存在BUG
     *
     * @param name 用户名
     * @param pwd  密码
     * @return 返回检索到的用户，如果没有匹配的用户，将返回null;
     */
    @Deprecated
    @Override
    public User userDisplay(String name, String pwd) {
        List<User> res = super.select("select * from user where name=?,pwd=?", name, pwd);
        if (res != null && res.size() == 1) return res.get(0);
        return null;
    }

    /**
     * 通过name来查找用户并返回，由于并未规定name是否可以重复，所以可能出现逻辑错误。
     *
     * @param name 用户名
     * @return 返回找到的用户
     */
    @Override
    public User userDisplay(String name) {
        List<User> res = super.select("select * from user where name=?", name);
        if (res != null && res.size() != 0) return res.get(0);
        return null;
    }

    @Override
    public boolean UserExists(String name) {
        return userDisplay(name) != null;
    }

    @Override
    public int userAdd(User user) {
        return super.insert("insert user(`name`,`pwd`,`type`,`updated_at`) values(?,?,?,?)", user.getName(), user.getPwd(), user.getType(), user.getUpdated_at());
    }

    @Override
    public boolean userDelete(int id) {
        return super.delete("delete from user where id=?", id) == 1;
    }

    @Override
    public boolean userUpdate(User user) {
        return super.update("update user set name=?,pwd=?,type=?,updated_at=? where id=?", user.getName(), user.getPwd(), user.getType(), user.getUpdated_at(), user.getId()) == 1;
    }

    @Override
    public int userAllCount() {
        return super.getInt("select count(*) from user");
    }

    @Override
    public int userAdminCount() {
        return super.getInt("select count(*) from user where type=?", User.ADMIN);
    }

    @Override
    public int userNormalCount() {
        return super.getInt("select count(*) from user where type=?", User.NORMAL);
    }
}
