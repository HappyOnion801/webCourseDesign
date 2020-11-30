package com.zh.courseDesign.web.dao;

import com.zh.courseDesign.web.dao.utils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个基类，用于反问数据库的通用操作，任何想要反问数据库的bean类，只要继承这个类然后实现各自的业务逻就可以了。
 * @author MaCode
 * @date 2020-11-29
 * @github HappyOnion801
 */
public abstract class BaseDAO<T> {

    private Class<T> clazz;

    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();//获取当前BaseDAO的子类继承的父类中的泛型
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        Type[] typeArguments = paramType.getActualTypeArguments();//获取了父类的泛型参数
        clazz = (Class<T>) typeArguments[0];//泛型的第一个参数
    }

    /**
     * @param con 数据库连接对象
     * @param sql sql语句
     * @param args 参数
     * @return 返回受影响的行数
     * 该方法并不对外开放，是用来实现增删改的通用方法
     */
    private int up(Connection con, String sql, Object args[]) {
        PreparedStatement ps = null;
        int res = -1;
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (int i = 0; i < args.length; i++) {
            try {
                ps.setObject(i + 1, args[i]);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            res = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        JDBCUtils.closeResource(null, ps, null);
        return res;
    }

    /**
     * @param con 数据库连接对象
     * @param sql sql语句
     * @param args 参数
     * @return 返回结果表
     */
    private List<T> query(Connection con, String sql, Object args[]) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        List<T> res = null;
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < args.length; i++) {
            try {
                ps.setObject(i + 1, args[i]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            res = new ArrayList<>();
            while (rs.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    Field field = clazz.getClass().getDeclaredField(rsmd.getColumnLabel(i + 1));
                    field.set(t, rs.getObject(i + 1));
                    res.add(t);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBCUtils.closeResource(null, ps, rs);
        return res;
    }

    public int insert(Connection con, String sql, Object... args) {
        int res = up(con, sql, args);
        return res;
    }

    public int insert(String sql, Object... args) {
        Connection con = JDBCUtils.getConnection();
        int res = up(con, sql, args);
        JDBCUtils.closeResource(con, null, null);
        return res;
    }

    public int delete(Connection con, String sql, Object... args) {
        int res = up(con, sql, args);
        return res;
    }

    public int delete(String sql, Object... args) {
        Connection con = JDBCUtils.getConnection();
        int res = up(con, sql, args);
        JDBCUtils.closeResource(con, null, null);
        return res;
    }

    public int update(Connection con, String sql, Object... args) {
        int res = up(con, sql, args);
        return res;
    }

    public int update(String sql, Object... args) {
        Connection con = JDBCUtils.getConnection();
        int res = up(con, sql, args);
        JDBCUtils.closeResource(con, null, null);
        return res;
    }

    public List<T> select(Connection con,String sql,Object ...args){
        List<T> res = query(con,sql,args);
        return res;
    }

    public List<T> select(String sql,Object ...args){
        Connection con = JDBCUtils.getConnection();
        List<T> res = query(con,sql,args);
        JDBCUtils.closeResource(con,null,null);
        return  res;
    }

}
