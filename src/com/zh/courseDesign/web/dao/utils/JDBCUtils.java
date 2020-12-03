package com.zh.courseDesign.web.dao.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 这是一个工具类，主要用于java访问数据库的一些辅助性操作，比如获取数据库连接和关闭资源等常用性操作。
 *
 * @author MaCode
 * @date 2020-11-29
 * @github HappyOnion801
 */
public class JDBCUtils {

    private static DataSource dataSource = null;

    static {
        Properties properties = new Properties();
        try {
            String path = JDBCUtils.class.getResource("/").getPath();
            System.out.println(path);
            properties.load(JDBCUtils.class.getResourceAsStream("/database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个数据库数据库连接，该连接从数据库连接池获取
     *
     * @return 返回一个数据库连接对象
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    /**
     * 用来关闭各种数据库资源
     *
     * @param con 数据连接对象
     * @param ps  PreparedStatement对象
     * @param rs  结果集对象
     */
    public static void closeResource(Connection con, PreparedStatement ps, ResultSet rs) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
