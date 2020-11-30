package com.zh.courseDesign.web.dao;

import com.zh.courseDesign.web.bean.TestBean;

/**
 * @author MaCode
 * @date 2020-11-29
 * @github HappyOnion801
 */
public class TestDAO extends BaseDAO<TestBean>{
    public int inset(TestBean testBean){
        int res = super.insert("insert test(name,price) values(?,?)",testBean.getName(),testBean.getPrice());
        return res;
    }
}
