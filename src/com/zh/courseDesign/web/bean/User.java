package com.zh.courseDesign.web.bean;

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

    public User(int id, String name, String pwd, Integer type, String updated_at) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.type = type;
        this.updated_at = updated_at;
    }

    public User(String name, String pwd, Integer type, String updated_at) {
        this.name = name;
        this.pwd = pwd;
        this.type = type;
        this.updated_at = updated_at;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", type=" + type +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }

    /**
     * 该方法用来返回对象的json字符串，以便于对象在web端的传输
     * @return 对象的json字符串
     */
    public String toJson() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ",\"name\":\"" + name + '\"' +
                ",\"type\":\"" + type + '\"' +
                ",\"updated_at\":\"" + updated_at + '\"' +
                '}';
    }
}
