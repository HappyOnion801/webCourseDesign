package com.zh.courseDesign.web;

import com.zh.courseDesign.web.bean.TestBean;
import com.zh.courseDesign.web.dao.TestDAO;
import com.zh.courseDesign.web.dao.utils.JDBCUtils;
import org.junit.Test;

/**
 * @author MaCode
 * @date 2020-11-29
 * @github HappyOnion801
 */
public class TestUnit {
    @Test
    public void getConnection(){
        System.out.println(JDBCUtils.getConnection());
    }
    @Test
    public void insert(){
        TestBean testBean = new TestBean("zhanghao",1000);
        TestDAO testDAO = new TestDAO();
        System.out.println(testDAO.inset(testBean));
    }
}
