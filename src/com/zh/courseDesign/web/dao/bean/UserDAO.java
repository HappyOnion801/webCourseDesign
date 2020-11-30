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

    private static Properties properties = null;

    static {
        properties = new Properties();
        try {
            properties.load(UserDAO.class.getClassLoader().getResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> userList(int page) {
        Integer limit = Integer.valueOf(properties.getProperty("limit"));
        return super.select("select * from user limit ?,?", (page-1) * limit, limit);
    }

    @Override
    public List<User> userAdminList(int page) {
        Integer limit = Integer.valueOf(properties.getProperty("limit"));
        return super.select("select * from user where type=2 limit ?,?", page * limit, limit);
    }

    @Override
    public List<User> userNormalList(int page) {
        Integer limit = Integer.valueOf(properties.getProperty("limit"));
        return super.select("select * from user where type=1 limit ?,?", page * limit, limit);
    }

    @Override
    public User userDisplay(int id) {
        List<User> res = super.select("select * from user where id=?", id);
        if (res != null && res.size() == 1) return res.get(0);
        return null;
    }

    @Override
    public User userDisplay(String name, String pwd) {
        List<User> res = super.select("select * from user where name=?,pwd=?", name, pwd);
        if (res != null && res.size() == 1) return res.get(0);
        return null;
    }

    @Override
    public User userDisplay(String name) {
        List<User> res = super.select("select * from user where name=?", name);
        if (res != null && res.size() == 1) return res.get(0);
        return null;
    }

    @Override
    public boolean UserExists(String name) {
        int res = super.getInt("select count(*) from user where name=?", name);
        if (res == 1) return true;
        return false;
    }

    @Override
    public int userAdd(User user) {
        return super.insert("insert user(`name`,`pwd`,`type`,`updated_at`) values(?,?,?,?)", user.getName(), user.getPwd(), user.getType(), user.getUpdated_at());
    }

    @Override
    public boolean userDelete(int id) {
        int res = super.delete("delete from user where id=?", id);
        if (res == 1) return true;
        return false;
    }

    @Override
    public boolean userUpdate(User user) {
        int res = super.update("update user set name=?,pwd=?,type=?,updated_at=? where id=?", user.getName(), user.getPwd(), user.getType(), user.getUpdated_at(), user.getId());
        if (res == 1) return true;
        return false;
    }

    @Override
    public int userAllCount() {
        return super.getInt("select count(*) from user");
    }

    @Override
    public int userAdminCount() {
        return super.getInt("select count(*) from where type=?", 1);
    }

    @Override
    public int userNormalCount() {
        return super.getInt("select count(*) from where type=?", 2);
    }
}
