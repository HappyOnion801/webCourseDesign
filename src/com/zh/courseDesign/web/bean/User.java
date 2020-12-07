package com.zh.courseDesign.web.bean;

import com.zh.courseDesign.web.dao.bean.UserDAO;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户的bean对象，用于实现了user表的ORM。用于表示一个用户对象
 *
 * @author MaCode
 * @date 2020-11-30
 * @github HappyOnion801
 */
public class User {

    public static int ADMIN = 1;
    public static int NORMAL = 2;
    private String[] UserTYPE = {"","管理员","普通用户"};

    private Integer id;
    private String name;
    private String pwd;
    private Integer type;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public User() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.updated_at = simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    public User(Integer id, String name, String pwd, Integer type) {
        this();
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.type = type;
    }

    public User(String name, String pwd, Integer type) {
        this();
        this.name = name;
        this.pwd = pwd;
        this.type = type;
    }

    /**
     * 该方法用来返回对象的json字符串，以便于对象在web端的传输
     *
     * @return 对象的json字符串
     */
    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ",\"name\":\"" + name + '\"' +
                ",\"type\":\"" + UserTYPE[type] + '\"' +
                ",\"updated_at\":\"" + updated_at + '\"' +
                '}';
    }
}
